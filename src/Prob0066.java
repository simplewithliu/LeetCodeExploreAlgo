package com.leetcode.explore;

/*

��һ

����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
����Լ���������� 0 ֮�⣬��������������㿪ͷ��

ʾ�� 1:
����: [1,2,3]
���: [1,2,4]
����: ���������ʾ���� 123��

ʾ�� 2:
����: [4,3,2,1]
���: [4,3,2,2]
����: ���������ʾ���� 4321��
 
*/

public class Prob0066
{
	class Solution
	{
		public int[] plusOne(int[] digits)
		{
			for (int i = digits.length - 1; i >= 0; --i)
			{
				if (digits[i] < 9)
				{
					++digits[i];
					return digits;
				}
				digits[i] = 0;
			}
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
	}
}
