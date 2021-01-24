package com.leetcode.explore;

/*

��������

ͳ������С�ڷǸ����� n ��������������

ʾ�� 1��
���룺n = 10
�����4
���ͣ�С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��

ʾ�� 2��
���룺n = 0
�����0

ʾ�� 3��
���룺n = 1
�����0
 
��ʾ��
0 <= n <= 5 * 106

*/

public class Prob0204 {
	class Solution {
		public int countPrimes(int n) {
			boolean[] notPrime = new boolean[n];
			int res = 0;
			for (int i = 2; i < n; ++i) {
				if (!notPrime[i]) {
					++res;
					// i*i<n may overflow
					if (i <= (n - 1) / i) {
						for (int j = i * i; j < n; j += i) {
							notPrime[j] = true;
						}
					}
				}
			}
			return res;
		}
	}
}
