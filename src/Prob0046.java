package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

46. ȫ����
����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�

ʾ�� 1��
���룺nums = [1,2,3]
�����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

ʾ�� 2��
���룺nums = [0,1]
�����[[0,1],[1,0]]

ʾ�� 3��
���룺nums = [1]
�����[[1]]

��ʾ��
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums �е��������� ������ͬ

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
