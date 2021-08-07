package com.leetcode.explore;

/*

94. ���������������

����һ���������ĸ��ڵ� root ���������� ���� ������

ʾ�� 1��
���룺root = [1,null,2,3]
�����[1,3,2]

ʾ�� 2��
���룺root = []
�����[]

ʾ�� 3��
���룺root = [1]
�����[1]

ʾ�� 4��
���룺root = [1,2]
�����[2,1]

ʾ�� 5��
���룺root = [1,null,2]
�����[1,2]

��ʾ��
���нڵ���Ŀ�ڷ�Χ [0, 100] ��
-100 <= Node.val <= 100

����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob0094 {
    // �ݹ�
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        void inorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }

    // ����
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> s = new Stack<>();
            List<Integer> res = new ArrayList<>();
            TreeNode node = root;
            while (!s.isEmpty() || node != null) {
                if (node != null) {
                    s.push(node);
                    node = node.left;
                } else {
                    node = s.pop();
                    res.add(node.val);
                    node = node.right;
                }
            }
            return res;
        }
    }

    // Ī��˹����
    class Solution3 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode cur = root, pre = null;
            while (cur != null) {
                if (cur.left == null) {
                    res.add(cur.val);
                    cur = cur.right;
                } else {
                    pre = cur.left;
                    while (pre.right != null && pre.right != cur) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        pre.right = null;
                        res.add(cur.val);
                        cur = cur.right;
                    }
                }
            }
            return res;
        }
    }
}
