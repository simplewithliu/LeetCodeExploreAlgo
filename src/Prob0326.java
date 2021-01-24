package com.leetcode.explore;

/*

3����

����һ��������дһ���������ж����Ƿ��� 3 ���ݴη�������ǣ����� true �����򣬷��� false ��
���� n �� 3 ���ݴη������㣺�������� x ʹ�� n == 3 ^ x

ʾ�� 1��
���룺n = 27
�����true

ʾ�� 2��
���룺n = 0
�����false

ʾ�� 3��
���룺n = 9
�����true

ʾ�� 4��
���룺n = 45
�����false

��ʾ��-231 <= n <= 231 - 1
 
���ף����ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����

*/

public class Prob0326 {
	class Solution1 {
		public boolean isPowerOfThree(int n) {
			if (n < 1) return false;
			while (n % 3 == 0) {
				n /= 3;
			}
			return n == 1;
		}
	}

	class Solution2 {
		public boolean isPowerOfThree(int n) {
			double epsilon = 1e-10;
			return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
		}
	}
}
// https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/