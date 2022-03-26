package com.leetcode.explore;

/*

117. 填充每个节点的下一个右侧节点指针 II

给定一个二叉树

struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
}

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

示例：
输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树, 你的函数应该填充它的每个 next 指针, 以指向其下一个右侧节点。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。

提示：
树中的节点数小于 6000
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

    // 迭代
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

    // 递归
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

