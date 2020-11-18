package com.leetcode.explore;

/*

ʵ��strStr() (KMP�㷨)

����һ��haystack�ַ�����һ��needle�ַ�������haystack�ַ������ҳ�needle�ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻� -1��

ʾ�� 1:
����: haystack = "hello", needle = "ll"
���: 2

ʾ�� 2:
����: haystack = "aaaaa", needle = "bba"
���: -1

˵��:
��needle�ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣
���ڱ�����ԣ���needle�ǿ��ַ���ʱ����Ӧ������ 0������C���Ե�strstr()�Լ�Java��indexOf()���������

*/

public class Prob0028 {
	class Solution {
		public int strStr(String haystack, String needle) {
			int patLen = needle.length();
			int hayLen = haystack.length();
			if (patLen == 0)
				return 0;
			// ��Ŀ��Ĭ��ֻ��Сд��ĸ
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
			// flag����pat�д������ͬǰ��׺ʱ�ĺ���״̬
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
