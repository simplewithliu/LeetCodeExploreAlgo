package com.leetcode.explore;

import java.util.Arrays;

/*

��ʧ������

����һ������ [0, n] �� n ���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����

���ף����ܷ�ʵ������ʱ�临�Ӷȡ���ʹ�ö��ⳣ���ռ���㷨���������?
 
ʾ�� 1��
���룺nums = [3,0,1]
�����2
���ͣ�n = 3����Ϊ�� 3 �����֣��������е����ֶ��ڷ�Χ [0,3] �ڡ�2 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�

ʾ�� 2��
���룺nums = [0,1]
�����2
���ͣ�n = 2����Ϊ�� 2 �����֣��������е����ֶ��ڷ�Χ [0,2] �ڡ�2 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�

ʾ�� 3��
���룺nums = [9,6,4,2,3,5,7,0,1]
�����8
���ͣ�n = 9����Ϊ�� 9 �����֣��������е����ֶ��ڷ�Χ [0,9] �ڡ�8 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�

ʾ�� 4��
���룺nums = [0]
�����1
���ͣ�n = 1����Ϊ�� 1 �����֣��������е����ֶ��ڷ�Χ [0,1] �ڡ�1 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�
 
��ʾ��
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
nums�е��������ֶ���һ�޶�

*/

public class Prob0268 {
	class Solution1 {
		public int missingNumber(int[] nums) {
			int res = nums.length;
			for (int i = 0; i < nums.length; ++i) {
				res ^= i;
				res ^= nums[i];
			}
			return res;
		}
	}

	class Solution2 {
		public int missingNumber(int[] nums) {
			int sum = (0 + nums.length) * (nums.length + 1) / 2;
			for (int i = 0; i < nums.length; ++i) sum -= nums[i];
			return sum;
		}
	}

	// ���������������Ч�ʸ�
	class Solution3 {
		public int missingNumber(int[] nums) {
			Arrays.sort(nums);
			int lo = 0, hi = nums.length;
			while (lo < hi) {
				int mi = lo + (hi - lo) / 2;
				if (nums[mi] > mi)
					hi = mi;
				else
					lo = mi + 1;
			}
			return lo;
		}
	}
}
