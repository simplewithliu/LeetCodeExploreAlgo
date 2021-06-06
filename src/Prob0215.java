package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

数组中的第K个最大元素

在未排序的数组中找到第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

*/

// 与0347类似，可以使用堆或快速划分
public class Prob0215 {
    // 快速划分
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            int lo = 0, hi = nums.length - 1;
            int target = nums.length - k;
            List<Integer> data = new ArrayList<Integer>();
            for (final int num : nums) data.add(num);
            int index = partition(data, lo, hi);
            while (index != target) {
                if (index > target) {
                    hi = index - 1;
                    index = partition(data, lo, hi);
                } else {
                    lo = index + 1;
                    index = partition(data, lo, hi);
                }
            }
            return data.get(index);
        }

        private int partition(List<Integer> data, int lo, int hi) {
            Collections.swap(data, lo, lo + ((int) Math.random() % (hi - lo + 1)));
            int pivot = data.get(lo);
            while (lo < hi) {
                while (lo < hi) {
                    if (data.get(hi) > pivot) {
                        --hi;
                    } else {
                        data.set(lo++, data.get(hi));
                        break;
                    }
                }
                while (lo < hi) {
                    if (data.get(lo) < pivot) {
                        ++lo;
                    } else {
                        data.set(hi--, data.get(lo));
                        break;
                    }
                }
            }
            data.set(lo, pivot);
            return lo;
        }
    }

    // 最大堆或最小堆
    // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            if (k <= len - k) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                for (int i = 0; i < k; ++i) {
                    minHeap.add(nums[i]);
                }
                for (int i = k; i < len; ++i) {
                    if (nums[i] > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.add(nums[i]);
                    }
                }
                return minHeap.peek();
            } else {
                int n = len - k + 1;
                PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                for (int i = 0; i < n; ++i) {
                    maxHeap.add(nums[i]);
                }
                for (int i = n; i < len; ++i) {
                    if (nums[i] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(nums[i]);
                    }
                }
                return maxHeap.peek();
            }
        }
    }
}
