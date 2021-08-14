package com.leetcode.explore;

import java.util.*;

/*

103. �������ľ���β������

����һ����������������ڵ�ֵ�ľ���β�������������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���

���磺
���������� [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

���ؾ���β���������£�
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
