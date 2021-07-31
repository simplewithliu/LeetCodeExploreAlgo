package com.leetcode.explore;

/*

162. Ѱ�ҷ�ֵ

��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�

����һ����������nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�

����Լ���nums[-1] = nums[n] = -��

ʾ�� 1��
���룺nums = [1,2,3,1]
�����2
���ͣ�3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2

ʾ��2��
���룺nums = [1,2,1,3,5,6,4]
�����1 �� 5
���ͣ���ĺ������Է������� 1�����ֵԪ��Ϊ 2�����߷������� 5�� ���ֵԪ��Ϊ 6

��ʾ��
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
����������Ч�� i ���� nums[i] != nums[i + 1]

���ף������ʵ��ʱ�临�Ӷ�Ϊ O(logN) �Ľ��������

*/

public class Prob0162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[mi] > nums[mi + 1]) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }
            return lo;
        }
    }
}
