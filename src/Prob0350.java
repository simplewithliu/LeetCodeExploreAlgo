package com.leetcode.explore;

import java.util.*;

/*

��������Ľ��� II

�����������飬��дһ���������������ǵĽ�����

ʾ�� 1��
���룺nums1 = [1,2,2,1], nums2 = [2,2]
�����[2,2]

ʾ�� 2:
���룺nums1 = [4,9,5], nums2 = [9,4,9,8,4]
�����[4,9]

˵����
��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ִ�������Сֵһ�¡�
���ǿ��Բ�������������˳��

���ף�
��������������Ѿ��ź����أ��㽫����Ż�����㷨��
��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
��� nums2 ��Ԫ�ش洢�ڴ����ϣ����ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿

*/

public class Prob0350 {
	class Solution1 {
		public int[] intersect(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int len1 = nums1.length, len2 = nums2.length;
			int[] res = new int[Math.min(len1, len2)];
			int idx1 = 0, idx2 = 0, idx = 0;
			while (idx1 < len1 && idx2 < len2) {
				if (nums1[idx1] < nums2[idx2])
					++idx1;
				else if (nums1[idx1] > nums2[idx2])
					++idx2;
				else {
					res[idx] = nums1[idx1];
					++idx1;
					++idx2;
					++idx;
				}
			}
			return Arrays.copyOfRange(res, 0, idx);
		}
	}

	class Solution2 {
		public int[] intersect(int[] nums1, int[] nums2) {
			if (nums1.length > nums2.length)
				return intersect(nums2, nums1);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int num : nums1) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			int[] res = new int[nums1.length];
			int idx = 0;
			for (int num : nums2) {
				int count = map.getOrDefault(num, 0);
				if (count > 0) {
					res[idx++] = num;
					--count;
					if (count > 0)
						map.put(num, count);
					else
						map.remove(num);
				}
			}
			return Arrays.copyOfRange(res, 0, idx);
		}
	}
}
//https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
