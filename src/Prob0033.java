package com.leetcode.explore;

/*

33. ������ת��������

�������� nums ���������У������е�ֵ������ͬ ��

�ڴ��ݸ�����֮ǰ��nums��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ�������ת��ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±��0��ʼ������

���磬[0,1,2,4,5,6,7] ���±�3������ת����ܱ�Ϊ [4,5,6,7,0,1,2]

������ת�������nums��һ������target�����nums�д������Ŀ��ֵtarget ���򷵻������±꣬���򷵻�-1 ��

ʾ�� 1��
���룺nums = [4,5,6,7,0,1,2], target = 0
�����4

ʾ�� 2��
���룺nums = [4,5,6,7,0,1,2], target = 3
�����-1

ʾ�� 3��
���룺nums = [1], target = 0
�����-1

��ʾ��
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums�е�ÿ��ֵ����һ�޶�
��Ŀ���ݱ�֤nums��Ԥ��δ֪��ĳ���±��Ͻ�������ת
-10^4 <= target <= 10^4

���ף���������һ��ʱ�临�Ӷ�ΪO(log n)�Ľ��������

*/

public class Prob0033 {
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[lo] < nums[mi]) {
                    if (target <= nums[mi] && nums[lo] <= target) hi = mi;
                    else lo = mi + 1;
                } else if (nums[lo] > nums[mi]) {
                    if (target > nums[mi] && nums[hi] >= target) lo = mi + 1;
                    else hi = mi;
                } else {
                    if (target == nums[mi]) return lo;
                    ++lo;
                }
            }
            return nums[lo] == target ? lo : -1;
        }
    }
}
