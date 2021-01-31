package com.leetcode.explore;

/*

��������

��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
������������ x �� y����������֮��ĺ������롣

ע�⣺
0 �� x, y < 231.

ʾ��:
����: x = 1, y = 4
���: 2

����:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��

����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�

*/

public class Prob0461 {
	class Solution {
		public int hammingDistance(int x, int y) {
			int res = 0;
			int num = x ^ y;
			while (num != 0) {
				++res;
				num &= num - 1;
			}
			return res;
		}
	}
}
