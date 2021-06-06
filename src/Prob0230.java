package com.leetcode.explore;

/*

230. �����������е�KС��Ԫ��

����һ�������������ĸ��ڵ� root ����һ������ k ���������һ���㷨�������е� k ����СԪ�أ��� 1 ��ʼ��������

ʾ�� 1��
���룺root = [3,1,4,null,2], k = 1
�����1

ʾ�� 2��
���룺root = [5,3,6,2,4,null,null,1], k = 3
�����3

��ʾ��
���еĽڵ���Ϊ n ��
1 <= k <= n <= 104
0 <= Node.val <= 104

���ף���������������������޸ģ�����/ɾ����������������ҪƵ���ز��ҵ� k С��ֵ���㽫����Ż��㷨��

*/

public class Prob0230 {
    class Solution {
        private int count = 1;
        private int res = 0;

        public int kthSmallest(TreeNode root, int k) {
            helper(root, k);
            return res;
        }

        private boolean helper(TreeNode node, int k) {
            if (node == null) return false;
            if (helper(node.left, k)) return true;
            if (count == k) {
                res = node.val;
                return true;
            }
            ++count;
            return helper(node.right, k);
        }
    }
}
