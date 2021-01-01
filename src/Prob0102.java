package com.leetcode.explore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

�������Ĳ������

����һ�������������㷵���䰴��������õ��Ľڵ�ֵ��������, �����ҷ������нڵ㣩

 ʾ����
��������[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
�����������������
[
  [3],
  [9,20],
  [15,7]
]

*/

public class Prob0102 {
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			if (root == null) return res;
			Queue<TreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				List<Integer> l = new ArrayList<>();
				int len = q.size();
				for (int i = 0; i < len; ++i) {
					TreeNode node = q.poll();
					l.add(node.val);
					if (node.left != null) q.offer(node.left);
					if (node.right != null) q.offer(node.right);
				}
				res.add(l);
			}
			return res;
		}
	}
}
