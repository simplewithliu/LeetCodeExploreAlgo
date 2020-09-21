package com.leetcode.explore;

import java.util.*;

/*

两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。

进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，但内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

*/

public class Prob0350 {
	class Solution1 {
		public int[] intersect(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int len1 = nums1.length, len2 = nums2.length;
			int[] res = new int[Math.min(len1, len2)];
			int idx1 = 0, idx2 = 0, idx = 0;
			while (idx1 < len1 && idx2 < len2) {
				if (nums1[idx1] < nums2[idx2])
					++idx1;
				else if (nums1[idx1] > nums2[idx2])
					++idx2;
				else {
					res[idx] = nums1[idx1];
					++idx1;
					++idx2;
					++idx;
				}
			}
			return Arrays.copyOfRange(res, 0, idx);
		}
	}

	class Solution2 {
		public int[] intersect(int[] nums1, int[] nums2) {
			if (nums1.length > nums2.length)
				return intersect(nums2, nums1);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int num : nums1) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			int[] res = new int[nums1.length];
			int idx = 0;
			for (int num : nums2) {
				int count = map.getOrDefault(num, 0);
				if (count > 0) {
					res[idx++] = num;
					--count;
					if (count > 0)
						map.put(num, count);
					else
						map.remove(num);
				}
			}
			return Arrays.copyOfRange(res, 0, idx);
		}
	}
}
//https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
