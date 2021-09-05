package com.leetcode.explore;

/*

55. ��Ծ��Ϸ

����һ���Ǹ���������nums �������λ������ĵ�һ���±ꡣ�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ��ж����Ƿ��ܹ��������һ���±ꡣ

ʾ�� 1��
���룺nums = [2,3,1,1,4]
�����true
���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ

ʾ�� 2��
���룺nums = [3,2,1,0,4]
�����false
���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ

��ʾ��
1 <= nums.length <= 3 * 10 ^ 4
0 <= nums[i] <= 10 ^ 5

*/

public class Prob0055 {

    // ��ǰ���
    class Solution1 {
        public boolean canJump(int[] nums) {
            if (nums.length == 0) return false;
            int i = 0;
            for (int reach = 0; i < nums.length && i <= reach; ++i) {
                reach = Math.max(i + nums[i], reach);
            }
            return i == nums.length;
        }
    }

    // �ɺ���ǰ
    class Solution2 {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; --i) {
                if (nums[i] + i >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }
}
