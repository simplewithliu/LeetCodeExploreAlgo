package com.leetcode.explore;

import java.util.Stack;

/*

验证二叉搜索树

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true

示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false

解释: 
输入为: [5,1,4,null,null,3,6] 根节点的值为 5, 但是其右子节点值为 4

*/

public class Prob0098 {

	// 迭代法
	class Solution1 {
		public boolean isValidBST(TreeNode root) {
			if (root == null) return true;
			Stack<TreeNode> s = new Stack<>();
			TreeNode node = root;
			TreeNode pre = null;
			while (!s.empty() || node != null) {
				if (node != null) {
					s.push(node);
					node = node.left;
				} else {
					node = s.pop();
					if (pre != null && node.val <= pre.val)
						return false;
					pre = node;
					node = node.right;
				}
			}
			return true;
		}
	}

	// 递归法
	class Solution2 {
		TreeNode pre = null;

		public boolean isValidBST(TreeNode root) {
			if (root == null) return true;
			if (!isValidBST(root.left)) return false;
			if (pre != null && root.val <= pre.val) return false;
			pre = root;
			return isValidBST(root.right);
		}
	}
}


