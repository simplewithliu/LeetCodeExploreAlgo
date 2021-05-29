package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

前K个高频元素

给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。

你可以按 任意顺序 返回答案。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]

提示：
1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前k个高频元素的集合是唯一的

进阶：你所设计算法的时间复杂度 必须 优于 O(nlogn) ，其中n是数组大小。

*/

public class Prob0347 {

	// 最小堆
	class Solution1 {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> occur = new HashMap<>();
			for (int num : nums) {
				occur.put(num, occur.getOrDefault(num, 0) + 1);
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			for (Map.Entry<Integer, Integer> entry : occur.entrySet()) {
				int num = entry.getKey(), count = entry.getValue();
				if (pq.size() == k) {
					if (pq.peek()[1] < count) {
						pq.poll();
						pq.offer(new int[] { num, count });
					}
				} else {
					pq.offer(new int[] { num, count });
				}
			}
			int[] res = new int[k];
			for (int i = 0; i < k; ++i) {
				res[i] = pq.poll()[0];
			}
			return res;
		}
	}
	
	// 桶排序
	class Solution2 {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> occur = new HashMap<>();
			for (int num : nums) {
				occur.put(num, occur.getOrDefault(num, 0) + 1);
			}
			List<List<Integer>> bucket = new ArrayList<>();
			int idx = 0;
			while (idx++ <= nums.length + 1) bucket.add(new ArrayList<>());
			for (Map.Entry<Integer, Integer> entry : occur.entrySet()) {
				int num = entry.getKey(), count = entry.getValue();
				bucket.get(count).add(num);
			}
			int[] res = new int[k];
			idx = 0;
			for (int i = nums.length; i >= 0; --i) {
				for (int num : bucket.get(i)) {
					res[idx++] = num;
					if (idx == k) return res;
				}
			}
			return res;
		}
	}
	
	// 快速划分
	class Solution3 {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> occur = new HashMap<>();
			for (int num : nums) {
				occur.put(num, occur.getOrDefault(num, 0) + 1);
			}
			List<int[]> data = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : occur.entrySet()) {
				int num = entry.getKey(), count = entry.getValue();
				data.add(new int[] { num, count });
			}
			int lo = 0, hi = data.size() - 1;
			int index = partiton(data, lo, hi);
			while (index != k - 1) {
				if (index > k - 1) {
					hi = index - 1;
					index = partiton(data, lo, hi);
				} else {
					lo = index + 1;
					index = partiton(data, lo, hi);
				}
			}
			int[] res = new int[k];
			for (int i = 0; i <= index; ++i) {
				res[i] = data.get(i)[0];
			}
			return res;
		}

		private int partiton(List<int[]> data, int lo, int hi) {
			Collections.swap(data, lo, lo + ((int) Math.random()) % (hi - lo + 1));
			int[] pivot = new int[] { data.get(lo)[0], data.get(lo)[1] };
			while (lo < hi) {
				while (lo < hi) {
					if (data.get(hi)[1] < pivot[1]) {
						--hi;
					} else {
						data.set(lo++, data.get(hi));
						break;
					}
				}
				while (lo < hi) {
					if (data.get(lo)[1] > pivot[1]) {
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
}
