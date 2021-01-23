package com.leetcode.explore;

/*
 
������Ʊ�����ʱ��

����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
ע�⣺�㲻���������Ʊǰ������Ʊ��

ʾ�� 1:
����: [7,1,5,3,6,4]
���: 5
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ������, �ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ������� = 6-1 = 5, ע���������� 7-1 = 6, �㲻��������ǰ������Ʊ��

ʾ�� 2:
����: [7,6,4,3,1]
���: 0
����: �����������, û�н������, �����������Ϊ 0��

*/

public class Prob0121 {
	class Solution {
		public int maxProfit(int[] prices) {
			int len = prices.length;
			if (len == 0) return 0;
			int[][] dp = new int[len][2];
			for (int i = 0; i < len; ++i) {
				if (i - 1 == -1) {
					dp[i][0] = 0;
					dp[i][1] = -prices[i];
					continue;
				}
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
				dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
			}
			return dp[len - 1][0];
		}
	}
}
