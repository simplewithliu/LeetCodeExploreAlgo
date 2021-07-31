package com.leetcode.explore;

/*

34. �����������в���Ԫ�صĵ�һ�������һ��λ��

����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á���������в�����Ŀ��ֵ target������ [-1, -1]��

���ף�
�������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨�����������

ʾ�� 1��
���룺nums = [5,7,7,8,8,10], target = 8
�����[3,4]

ʾ�� 2��
���룺nums = [5,7,7,8,8,10], target = 6
�����[-1,-1]

ʾ�� 3��
���룺nums = [], target = 0
�����[-1,-1]

��ʾ��
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums ��һ���ǵݼ�����
-10^9 <= target <= 10^9

*/

public class Prob0034 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int first = lowerBound(nums, target);
            if (first == -1) return new int[]{-1, -1};
            int second = upperBound(nums, target);
            return new int[]{first, second};
        }

        // ��ͬԪ�������Ԫ��
        int lowerBound(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[mi] < target) lo = mi + 1;
                else hi = mi;
            }
            return nums[lo] == target ? lo : -1;
        }

        // ��ͬԪ�����ұ�Ԫ��
        int upperBound(int[] nums, int target) {
            int len = nums.length;
            int lo = 0, hi = len - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo + 1) / 2;
                if (nums[mi] > target) hi = mi - 1;
                else lo = mi;
            }
            return nums[lo] == target ? lo : -1;
        }
    }
}
