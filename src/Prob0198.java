package com.leetcode.explore;

import java.util.Arrays;

/*

��ҽ���

����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
����һ������ÿ�����ݴ�Ž��ķǸ��������飬�����㲻��������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�

ʾ�� 1��
���룺[1,2,3,1]
�����4
���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��͵�Ե�����߽�� = 1 + 3 = 4 ��

ʾ�� 2��
���룺[2,7,9,3,1]
�����12
���ͣ�͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
 
��ʾ��
0 <= nums.length <= 100
0 <= nums[i] <= 400

*/

public class Prob0198 {
	class Solution1 {
		public int rob(int[] nums) {
			int len = nums.length;
			int[] memo = new int[len];
			Arrays.fill(memo, -1);
			return helper(nums, len - 1, memo);
		}

		private int helper(int[] nums, int index, int[] memo) {
			if (index < 0) return 0;
			if (memo[index] != -1) return memo[index];
			int res = Math.max(helper(nums, index - 2, memo) + nums[index], helper(nums, index - 1, memo));
			memo[index] = res;
			return res;
		}
	}

	class Solution2 {
		public int rob(int[] nums) {
			int len = nums.length;
			if (len == 0) return 0;
			int[] dp = new int[len + 1];
			dp[0] = 0;
			dp[1] = nums[0];
			for (int i = 2; i <= len; ++i) {
				dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
			}
			return dp[len];
		}
	}

	class Solution3 {
		public int rob(int[] nums) {
			int prev = 0;
			int cur = 0;
			for (int i : nums) {
				int temp = Math.max(cur, prev + i);
				prev = cur;
				cur = temp;
			}
			return cur;
		}
	}
}
