package com.leetcode.explore;

/*

��¥��

������������¥�ݡ���Ҫ n ������ܵ���¥����
ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
ע�⣺���� n ��һ����������

ʾ�� 1��
���룺 2
����� 2
���ͣ� �����ַ�����������¥����
1.  1 �� + 1 ��
2.  2 ��

ʾ�� 2��
���룺 3
����� 3
���ͣ� �����ַ�����������¥����
1.  1 �� + 1 �� + 1 ��
2.  1 �� + 2 ��
3.  2 �� + 1 ��

*/

public class Prob0070 {
	
	class Solution1 {
		public int climbStairs(int n) {
			int[] memo = new int[n + 1];
			return helper(n, memo);
		}

		int helper(int n, int[] memo) {
			if (n == 0 || n == 1) return 1;
			if (memo[n] != 0) return memo[n];
			return memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
		}
	}

	class Solution2 {
		public int climbStairs(int n) {
			if (n == 0 || n == 1) return 1;
			int[] dp = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i <= n; ++i) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}
	}

	class Solution3 {
		public int climbStairs(int n) {
			int pre = 1, cur = 1;
			for (int i = 2; i <= n; ++i) {
				int tmp = pre + cur;
				pre = cur;
				cur = tmp;
			}
			return cur;
		}
	}
}
