package com.leetcode.explore;

/*

33. 搜索旋转排序数组

整数数组 nums 按升序排列，数组中的值互不相同 。

在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）

例如，[0,1,2,4,5,6,7] 在下标3处经旋转后可能变为 [4,5,6,7,0,1,2]

给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target ，则返回它的下标，否则返回-1 。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums中的每个值都独一无二
题目数据保证nums在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4

进阶：你可以设计一个时间复杂度为O(log n)的解决方案吗？

*/

public class Prob0033 {
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[lo] < nums[mi]) {
                    if (target <= nums[mi] && nums[lo] <= target) hi = mi;
                    else lo = mi + 1;
                } else if (nums[lo] > nums[mi]) {
                    if (target > nums[mi] && nums[hi] >= target) lo = mi + 1;
                    else hi = mi;
                } else {
                    if (target == nums[mi]) return lo;
                    ++lo;
                }
            }
            return nums[lo] == target ? lo : -1;
        }
    }
}
