package com.leetcode.explore;

import java.util.LinkedList;
import java.util.Queue;

/*

�Գƶ�����

����һ����������������Ƿ��Ǿ���ԳƵġ�
���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 
����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:

    1
   / \
  2   2
   \   \
   3    3
 

���ף���������õݹ�͵������ַ���������������

*/

public class Prob0101 {
	// ������
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

	// �ݹ鷨
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

