package com.leetcode.explore;

/*

94. 二叉树的中序遍历

给定一个二叉树的根节点 root ，返回它的 中序 遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[2,1]

示例 5：
输入：root = [1,null,2]
输出：[1,2]

提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob0094 {
    // 递归
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

    // 迭代
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

    // 莫里斯遍历
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
