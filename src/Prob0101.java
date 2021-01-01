package com.leetcode.explore;

import java.util.LinkedList;
import java.util.Queue;

/*

对称二叉树

给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 

进阶：你可以运用递归和迭代两种方法解决这个问题吗？

*/

public class Prob0101 {
	// 迭代法
	class Solution1 {
		public boolean isSymmetric(TreeNode root) {
			if (root == null) return true;
			Queue<TreeNode> q = new LinkedList<>();
			q.offer(root.left);
			q.offer(root.right);
			while (!q.isEmpty()) {
				TreeNode l = q.poll();
				TreeNode r = q.poll();
				if (l == null && r == null) continue;
				if ((l == null || r == null) || (l.val != r.val)) return false;
				q.offer(l.left);
				q.offer(r.right);
				q.offer(l.right);
				q.offer(r.left);
			}
			return true;
		}
	}

	// 递归法
	class Solution2 {
		public boolean isSymmetric(TreeNode root) {
			if (root == null) return true;
			return helper(root.left, root.right);
		}

		private boolean helper(TreeNode lc, TreeNode rc) {
			if (lc == null || rc == null) return lc == rc;
			else if (lc.val != rc.val) return false;
			else return helper(lc.left, rc.right) && helper(lc.right, rc.left);
		}
	}
}

