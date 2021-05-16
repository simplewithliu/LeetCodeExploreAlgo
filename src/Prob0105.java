package com.leetcode.explore;

/*
 
从前序与中序遍历序列构造二叉树

根据一棵树的前序遍历与中序遍历构造二叉树。

注意: 你可以假设树中没有重复的元素。

例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder  = [9,3,15,20,7]

返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

*/

public class Prob0105 {
	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			int len = preorder.length;
			if (len == 0) return null;
			return helper(preorder, 0, len - 1, inorder, 0, len - 1);
		}

		private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
			if (ps > pe) return null;
			TreeNode root = new TreeNode(preorder[ps]);
			int lcNum = 0;
			for (int i = is; inorder[i] != root.val; ++i) ++lcNum;
			root.left = helper(preorder, ps + 1, ps + lcNum, inorder, is, is + lcNum - 1);
			root.right = helper(preorder, ps + lcNum + 1, pe, inorder, is + lcNum + 1, ie);
			return root;
		}
	}
}
