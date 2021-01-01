package com.leetcode.explore;

/*

����������ת��Ϊ����������

��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ������������������У�һ���߶�ƽ���������ָһ��������ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:
������������: [-10,-3,0,5,9], һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5], ���Ա�ʾ��������߶�ƽ�����������:

      0
     / \
   -3   9
   /   /
 -10  5
 
*/

public class Prob0108 {
	class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			return findMiddle(nums, 0, nums.length - 1);
		}

		private TreeNode findMiddle(int[] nums, int lo, int hi) {
			if (lo > hi) return null;
			int mi = lo + (hi - lo) / 2;
			TreeNode node = new TreeNode(nums[mi]);
			node.left = findMiddle(nums, lo, mi - 1);
			node.right = findMiddle(nums, mi + 1, hi);
			return node;
		}
	}
}
