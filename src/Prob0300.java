package com.leetcode.explore;

import java.util.Arrays;

/*

300. 最长递增子序列

给你一个整数数组 nums，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为4

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4

进阶：
你可以设计时间复杂度为O(n2)的解决方案吗？
你能将算法的时间复杂度降低到O(nlog(n))吗?

*/

public class Prob0300 {
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[][] m = new int[len + 1][len];
            for (int[] arr : m) {
                Arrays.fill(arr, -1);
            }
            return helper(nums, -1, 0, m);
        }

        private int helper(int[] nums, int preIdx, int curIdx, int[][] m) {
            int len = nums.length;
            if (curIdx == len) return 0;
            if (m[preIdx + 1][curIdx] >= 0) return m[preIdx + 1][curIdx];
            int increNum = 0;
            if (preIdx < 0 || nums[curIdx] > nums[preIdx]) {
                increNum = 1 + helper(nums, curIdx, curIdx + 1, m);
            }
            int noIncreNum = helper(nums, preIdx, curIdx + 1, m);
            return m[preIdx + 1][curIdx] = Math.max(increNum, noIncreNum);
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int res = 0;
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }

    class Solution3 {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            int res = 0;
            for (int n : nums) {
                int lo = 0, hi = res;
                lo = biSearch(dp, lo, hi, n);
                if (lo == 0 || dp[lo - 1] < n) {
                    dp[lo] = n;
                    if (res == lo) ++res;
                }
            }
            return res;
        }

        // 相当于在有序数组中查找target，找不到就返回数组中比target大的最小值
        int biSearch(int[] nums, int lo, int hi, int target) {
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (target <= nums[mi]) hi = mi;
                else lo = mi + 1;
            }
            return lo;
        }
    }
}
