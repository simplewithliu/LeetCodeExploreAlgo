package com.leetcode.explore;

/*

给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"

提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

*/

public class Prob0005 {
	// 中心扩展
	class Solution1 {
		public String longestPalindrome(String s) {
			int maxNum = 0, idx = 0;
			for (int i = 0; i < s.length(); ++i) {
				int len1 = extend(s, i, i);
				int len2 = extend(s, i, i + 1);
				if (maxNum < Math.max(len1, len2)) {
					idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
					maxNum = Math.max(len1, len2);
				}
			}
			return s.substring(idx, idx + maxNum);
		}

		int extend(String s, int i, int j) {
			while (i >= 0 && j < s.length()) {
				if (s.charAt(i) != s.charAt(j)) break;
				--i;
				++j;
			}
			return j - i - 1;
		}
	}

	// Manacher
	class Solution2 {
		public String longestPalindrome(String s) {
			String str = preProcess(s);
			int len = str.length();
			// str回文串半径数组pal
			int[] pal = new int[len];
			// str回文串中心点
			int center = 0;
			// 以center为中心的右侧最远下标
			int maxRight = 0;
			// 原始最长回文串的起始位置
			int start = 0;
			// 原始回文串最长长度
			int maxLen = 0;
			for (int i = 0; i < len; ++i) {
				if (i < maxRight) {
					int mirror = 2 * center - i;
					pal[i] = Math.min(pal[mirror], maxRight - i);
				}
				// 下一次扩散的左右起点
				int left = i - (pal[i] + 1);
				int right = i + (pal[i] + 1);
				while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
					++pal[i];
					--left;
					++right;
				}
				if ((i + pal[i]) > maxRight) {
					maxRight = i + pal[i];
					center = i;
				}
				if (pal[i] > maxLen) {
					maxLen = pal[i];
					start = (i - maxLen) / 2;
				}
			}
			return s.substring(start, start + maxLen);
		}

		String preProcess(String s) {
			int len = s.length();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < len; ++i) {
				res.append('#');
				res.append(s.charAt(i));
			}
			res.append("#");
			return res.toString();
		}
	}
}
