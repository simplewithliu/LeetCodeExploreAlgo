package com.leetcode.explore;

/*

�ϲ�������������

�������������������� nums1 �� nums2�����㽫 nums2 �ϲ��� nums1 �У�ʹ nums1 ��Ϊһ���������顣

˵����
��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n ��
����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
 
ʾ����
���룺
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
�����[1,2,2,3,5,6]
 
��ʾ��
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n 
 
*/

public class Prob0088 {
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int i = m - 1, j = n - 1, k = m + n - 1;
			while (i >= 0 && j >= 0) {
				if (nums1[i] >= nums2[j]) nums1[k--] = nums1[i--];
				else nums1[k--] = nums2[j--];
			}
			while (j >= 0) nums1[k--] = nums2[j--];
		}
	}
}
