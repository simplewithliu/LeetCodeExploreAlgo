package com.leetcode.explore;

/*

334. ��������Ԫ������

����һ���������� nums ���ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
���������������Ԫ���±� (i, j, k) ������ i < j < k ��ʹ�� nums[i] < nums[j] < nums[k] ������ true �����򣬷��� false ��

ʾ�� 1��
���룺nums = [1,2,3,4,5]
�����true
���ͣ��κ� i < j < k ����Ԫ�鶼��������

ʾ�� 2��
���룺nums = [5,4,3,2,1]
�����false
���ͣ������������������Ԫ��

ʾ�� 3��
���룺nums = [2,1,5,0,4,6]
�����true
���ͣ���Ԫ�� (3, 4, 5) �������⣬��Ϊ nums[3] == 0 < nums[4] == 4 < nums[5] == 6

��ʾ��
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

���ף�����ʵ��ʱ�临�Ӷ�Ϊ O(n) ���ռ临�Ӷ�Ϊ O(1) �Ľ��������

*/

public class Prob0334 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n <= small) small = n;
                else if (n <= mid) mid = n;
                else return true;
            }
            return false;
        }
    }
}
