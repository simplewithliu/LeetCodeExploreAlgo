package com.leetcode.explore;

/*

��������������

����һ�����������ҳ��������ȡ������������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ����

���������� [3,9,20,null,null,15,7]��

    3
   / \
  9  20
    /  \
   15   7
   
�������������� 3

*/

public class Prob0104 {
	class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null) return 0;
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}
}

