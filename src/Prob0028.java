package com.leetcode.explore;

/*

实现strStr() (KMP算法)

给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2

示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1

说明:
当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当needle是空字符串时我们应当返回 0。这与C语言的strstr()以及Java的indexOf()定义相符。

*/

public class Prob0028 {
	class Solution {
		public int strStr(String haystack, String needle) {
			int patLen = needle.length();
			int hayLen = haystack.length();
			if (patLen == 0)
				return 0;
			// 题目中默认只有小写字母
			int[][] dp = new int[patLen][26];
			kmp(needle, dp);
			int j = 0;
			for (int i = 0; i < hayLen; ++i) {
				j = dp[j][haystack.charAt(i) - 'a'];
				if (j == patLen) {
					return i - patLen + 1;
				}
			}
			return -1;
		}

		private void kmp(String pat, int[][] dp) {
			int len = pat.length();
			dp[0][pat.charAt(0) - 'a'] = 1;
			// flag记忆pat中处于最长相同前后缀时的后退状态
			int flag = 0;
			for (int i = 1; i < len; ++i) {
				for (int ch = 0; ch < 26; ++ch) {
					dp[i][ch] = dp[flag][ch];
				}
				dp[i][pat.charAt(i) - 'a'] = i + 1;
				flag = dp[flag][pat.charAt(i) - 'a'];
			}
		}
	}
}
