package com.leetcode.explore;

import java.util.Stack;

/*

��֤����������

����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������
�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������

ʾ�� 1:
����:
    2
   / \
  1   3
���: true

ʾ�� 2:
����:
    5
   / \
  1   4
     / \
    3   6
���: false

����: 
����Ϊ: [5,1,4,null,null,3,6] ���ڵ��ֵΪ 5, ���������ӽڵ�ֵΪ 4

*/

public class Prob0098 {

	// ������
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

	// �ݹ鷨
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


