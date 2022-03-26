package com.leetcode.explore;

/*

117. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� II

����һ��������

struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}

�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣
����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
��ʼ״̬�£����� next ָ�붼������Ϊ NULL��

���ף�
��ֻ��ʹ�ó���������ռ䡣
ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�

ʾ����
���룺root = [1,2,3,4,5,null,7]
�����[1,#,2,3,#,4,5,7,#]
���ͣ�����������, ��ĺ���Ӧ���������ÿ�� next ָ��, ��ָ������һ���Ҳ�ڵ㡣���л�������������˳���� next ָ�����ӣ���'#' ��ʾÿ���ĩβ��

��ʾ��
���еĽڵ���С�� 6000
-100 <= node.val <= 100

*/

public class Prob0117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // ����
    class Solution1 {
        public Node connect(Node root) {
            Node pre = null;
            Node head = null;
            Node cur = root;
            while (cur != null) {
                while (cur != null) {
                    if (cur.left != null) {
                        if (pre != null) {
                            pre.next = cur.left;
                            pre = pre.next;
                        } else {
                            head = cur.left;
                            pre = head;
                        }
                    }
                    if (cur.right != null) {
                        if (pre != null) {
                            pre.next = cur.right;
                            pre = pre.next;
                        } else {
                            head = cur.right;
                            pre = head;
                        }
                    }
                    cur = cur.next;
                }
                cur = head;
                pre = null;
                head = null;
            }
            return root;
        }
    }

    // �ݹ�
    class Solution2 {
        public Node connect(Node root) {
            if (root == null) return null;
            if (root.left != null) {
                if (root.right != null) root.left.next = root.right;
                else root.left.next = findNext(root);
            }
            if (root.right != null) root.right.next = findNext(root);
            connect(root.right);
            connect(root.left);
            return root;
        }

        private Node findNext(Node node) {
            if (node == null) return null;
            while (node.next != null) {
                if (node.next.left != null) return node.next.left;
                if (node.next.right != null) return node.next.right;
                node = node.next;
            }
            return null;
        }
    }
}

