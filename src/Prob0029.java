package com.leetcode.explore;

/*

29. �������

��������������������dividend�ͳ���divisor�������������Ҫ��ʹ�ó˷��������� mod ����������ر�����dividend���Գ���divisor�õ����̡�
���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2

ʾ��1:
����: dividend = 10, divisor = 3
���: 3
����: 10/3 = truncate(3.33333..) = truncate(3) = 3

ʾ��2:
����: dividend = 7, divisor = -3
���: -2
����: 7/-3 = truncate(-2.33333..) = -2

��ʾ��
�������ͳ�����Ϊ 32 λ�з���������
������Ϊ0��
�������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [-2^31, 2^31-1]�������У�����������������򷵻� 2^31 - 1

*/

public class Prob0029 {
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == -1) return Integer.MAX_VALUE;
                else if (divisor == 1) return Integer.MIN_VALUE;
                else return (divisor & 1) == 1 ? divide(dividend + 1, divisor) : divide(dividend >> 1, divisor >> 1);
            }
            if (divisor == Integer.MIN_VALUE) return 0;
            int dvd = Math.abs(dividend), dvs = Math.abs(divisor), ans = 0;
            int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
            while (dvd >= dvs) {
                int temp = dvs, m = 1;
                while ((temp << 1) <= dvd && (temp << 1) > 0) {
                    temp <<= 1;
                    m <<= 1;
                }
                dvd -= temp;
                ans += m;
            }
            return ans * sign;
        }
    }
}
