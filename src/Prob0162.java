package com.leetcode.explore;

/*

162. 寻找峰值

峰值元素是指其值大于左右相邻值的元素。

给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设nums[-1] = nums[n] = -∞

示例 1：
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2

示例2：
输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；或者返回索引 5， 其峰值元素为 6

提示：
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]

进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？

*/

public class Prob0162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[mi] > nums[mi + 1]) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }
            return lo;
        }
    }
}
