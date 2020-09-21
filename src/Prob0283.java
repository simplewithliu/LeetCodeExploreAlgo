package com.leetcode.explore;

/*

�ƶ���

����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:
����: [0,1,0,3,12]
���: [1,3,12,0,0]

˵��:
������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������

*/

public class Prob0283 {
    class Solution {
	public void moveZeroes(int[] nums) {
	    if (nums.length == 0) {
		return;
	    }
	    for (int last = 0, cur = 0; cur < nums.length; ++cur) {
		if (nums[cur] != 0)
		    swap(nums, last++, cur);
	    }
	}

	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
    }
}
