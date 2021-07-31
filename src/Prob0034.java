package com.leetcode.explore;

/*

34. 在排序数组中查找元素的第一个和最后一个位置

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9

*/

public class Prob0034 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int first = lowerBound(nums, target);
            if (first == -1) return new int[]{-1, -1};
            int second = upperBound(nums, target);
            return new int[]{first, second};
        }

        // 相同元素最左边元素
        int lowerBound(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[mi] < target) lo = mi + 1;
                else hi = mi;
            }
            return nums[lo] == target ? lo : -1;
        }

        // 相同元素最右边元素
        int upperBound(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo + 1) / 2;
                if (nums[mi] > target) hi = mi - 1;
                else lo = mi;
            }
            return nums[lo] == target ? lo : -1;
        }
    }
}
