package com.leetcode.explore;

import java.util.*;

/*

�����ظ�Ԫ��

����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
�������һֵ�������г����������Σ��������� true �����������ÿ��Ԫ�ض�����ͬ���򷵻� false ��

ʾ�� 1:
����: [1,2,3,1]
���: true

ʾ�� 2:
����: [1,2,3,4]
���: false

ʾ�� 3:
����: [1,1,1,3,3,4,3,2,4,2]
���: true

*/

public class Prob0217 {
    
    class Solution1 {
	public boolean containsDuplicate(int[] nums) {
	    Arrays.sort(nums);
	    for (int i = 0; i < nums.length - 1; ++i) {
		if (nums[i] == nums[i + 1])
		    return true;
	    }
	    return false;
	}
    }

    class Solution2 {
	public boolean containsDuplicate(int[] nums) {
	    Set<Integer> s = new HashSet<>(nums.length);
	    for (var num : nums) {
		if (s.contains(num))
		    return true;
		s.add(num);
	    }
	    return false;
	}
    }
}
