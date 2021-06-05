package com.leetcode.explore;

/*

最大子序和

给定一个整数数组 nums, 找到一个具有最大和的连续子数组(子数组最少包含一个元素), 返回其最大和

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

*/

public class Prob0053 {
	class Solution1 {
		public int maxSubArray(int[] nums) {
			int len = nums.length;
			int res = Integer.MIN_VALUE;
			for (int i = 0; i < len; ++i) {
				int sum = 0;
				for (int j = i; j < len; ++j) {
					sum += nums[j];
					res = Math.max(res, sum);
				}
			}
			return res;
		}

		class Solution2 {
			public int maxSubArray(int[] nums) {
				int len = nums.length;
				if (len == 0) return 0;
				int[] dp = new int[len];
				dp[0] = nums[0];
				for (int i = 1; i < len; ++i) 
					dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
				int res = Integer.MIN_VALUE;
				for (int i = 0; i < len; ++i)
					res = Math.max(res, dp[i]);
				return res;
			}
		}

		class Solution3 {
			public int maxSubArray(int[] nums) {
				int len = nums.length;
				if (len == 0) return 0;
				int pre = nums[0];
				int res = pre;
				for (int i = 1; i < len; ++i) {
					pre = Math.max(nums[i], pre + nums[i]);
					res = Math.max(pre, res);
				}
				return res;
			}
		}

		class Solution4 {
			public int maxSubArray(int[] nums) {
				int len = nums.length;
				if (len == 0) return 0;
				return maxSubArray(nums, 0, len - 1);
			}

			private int maxCross(int[] nums, int lo, int mi, int hi) {
				int sum = 0;
				int leftMax = Integer.MIN_VALUE;
				for (int i = mi; i >= lo; --i) {
					sum += nums[i];
					if (sum > leftMax)
						leftMax = sum;
				}
				sum = 0;
				int rightMax = Integer.MIN_VALUE;
				for (int i = mi + 1; i <= hi; ++i) {
					sum += nums[i];
					if (sum > rightMax)
						rightMax = sum;
				}
				return leftMax + rightMax;
			}

			private int maxSubArray(int[] nums, int lo, int hi) {
				if (lo == hi) return nums[lo];
				int mi = lo + (hi - lo) / 2;
				return threeMax(maxSubArray(nums, lo, mi), maxSubArray(nums, mi + 1, hi), maxCross(nums, lo, mi, hi));
			}

			private int threeMax(int num1, int num2, int num3) {
				return Math.max(num1, Math.max(num2, num3));
			}
		}
	    /**
	     * 以 [ 1 , 2 , 3 , 4 , 5 ] 为例, 
	     * 最大子序和一定来自 [... 3 , 4 ...] (以3结尾以4开头的区间) & [1 , 2 , 3] & [4 , 5] 三个区间,
	     * 然后每个子区间遵循同样的逻辑，可作递归求解,
	     * https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
	     */
	    
	}
}
