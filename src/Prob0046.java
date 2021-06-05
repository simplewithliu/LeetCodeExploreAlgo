package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

46. 全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]

示例 3：
输入：nums = [1]
输出：[[1]]

提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同

*/

public class Prob0046 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) return res;
            boolean[] used = new boolean[nums.length];
            List<Integer> path = new ArrayList<>();
            helper(nums, path, used, res);
            return res;
        }

        private void helper(final int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
            int len1 = nums.length;
            int len2 = path.size();
            if (len1 == len2) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len1; ++i) {
                if (used[i] == true) continue;
                used[i] = true;
                path.add(nums[i]);
                helper(nums, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
