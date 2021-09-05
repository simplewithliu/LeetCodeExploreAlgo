package com.leetcode.explore;

import java.util.Random;

/*

169. 多数元素

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ? n/2 ? 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：
输入：[3,2,3]
输出：3

示例 2：
输入：[2,2,1,1,1,2,2]
输出：2

进阶：
尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

*/

public class Prob0169 {
    // 快速划分
    class Solution1 {
        public int majorityElement(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            int mi = nums.length / 2;
            int idx = partition(nums, lo, hi);
            while (idx != mi) {
                if (idx > mi) {
                    hi = idx - 1;
                    idx = partition(nums, lo, hi);
                } else {
                    lo = idx + 1;
                    idx = partition(nums, lo, hi);
                }
            }
            return nums[mi];
        }

        private int partition(int[] nums, int lo, int hi) {
            int pivotIdx = new Random().nextInt(hi - lo + 1) + lo;
            int pivot = nums[pivotIdx];
            nums[pivotIdx] = nums[lo];
            nums[lo] = pivot;
            while (lo < hi) {
                while (lo < hi) {
                    if (pivot < nums[hi]) {
                        --hi;
                    } else {
                        nums[lo++] = nums[hi];
                        break;
                    }
                }
                while (lo < hi) {
                    if (pivot > nums[lo]) {
                        ++lo;
                    } else {
                        nums[hi--] = nums[lo];
                        break;
                    }
                }
            }
            nums[lo] = pivot;
            return lo;
        }
    }

    // 摩尔投票
    class Solution2 {
        public int majorityElement(int[] nums) {
            int cur = nums[0];
            int times = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (times == 0) {
                    cur = nums[i];
                    times = 1;
                } else if (nums[i] == cur) {
                    ++times;
                } else {
                    --times;
                }
            }
            return cur;
        }
    }
}
