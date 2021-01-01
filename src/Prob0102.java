package com.leetcode.explore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

二叉树的层序遍历

给你一个二叉树，请你返回其按层序遍历得到的节点值（即逐层地, 从左到右访问所有节点）

 示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
返回其层序遍历结果：
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
