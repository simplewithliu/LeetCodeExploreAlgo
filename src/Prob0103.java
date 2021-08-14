package com.leetcode.explore;

import java.util.*;

/*

103. 二叉树的锯齿形层序遍历

给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回锯齿形层序遍历如下：
[
  [3],
  [20,9],
  [15,7]
]

*/

public class Prob0103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root == null) return res;
            q.offer(root);
            boolean leftToRight = true;
            while (!q.isEmpty()) {
                Deque<Integer> deque = new LinkedList<>();
                int len = q.size();
                for (int i = 0; i < len; ++i) {
                    TreeNode temp = q.poll();
                    if (leftToRight) deque.offerLast(temp.val);
                    else deque.offerFirst(temp.val);
                    if (temp.left != null) q.offer(temp.left);
                    if (temp.right != null) q.offer(temp.right);
                }
                res.add(new LinkedList<>(deque));
                leftToRight = !leftToRight;
            }
            return res;
        }
    }
}
