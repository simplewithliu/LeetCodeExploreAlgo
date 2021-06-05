package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

子集

给你一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。

解集不能包含重复的子集。你可以按任意顺序返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]

提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums中的所有元素互不相同

*/

public class Prob0078 {
	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> res = new ArrayList<>();
			List<Integer> path = new ArrayList<>();
			helper(res, path, nums, 0);
			return res;
		}

		private void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
			res.add(new ArrayList<>(path));
			for (int i = start; i < nums.length; ++i) {
				path.add(nums[i]);
				helper(res, path, nums, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}
}
