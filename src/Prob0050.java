package com.leetcode.explore;

/*

50. Pow(x, n)

ʵ�� pow(x, n) �������� x �� n ���ݺ������� x^n��

ʾ�� 1��
���룺x = 2.00000, n = 10
�����1024.00000

ʾ�� 2��
���룺x = 2.10000, n = 3
�����9.26100

ʾ�� 3��
���룺x = 2.00000, n = -2
�����0.25000
���ͣ�2^-2 = (1/2)^2 = 1/4 = 0.25

��ʾ��
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

*/


public class Prob0050 {
    // ����
    class Solution1 {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            if (n == 0) return 1;
            int ncp = n;
            if (n < 0) {
                if (n == Integer.MIN_VALUE) {
                    ++ncp;
                    ncp = -ncp;
                    return 1.0 / (x * helper(x, ncp));
                }
                ncp = -ncp;
            }
            double res = helper(x, ncp);
            return n < 0 ? (1.0 / res) : res;
        }

        double helper(double x, int n) {
            double res = 1.0;
            while (n != 0) {
                if ((n & 1) == 1) res *= x;
                x *= x;
                n /= 2;
            }
            return res;
        }
    }

    // �ݹ�
    class Solution2 {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            if (n == 0) return 1;
            int ncp = n;
            if (n < 0) {
                if (n == Integer.MIN_VALUE) {
                    ++ncp;
                    ncp = -ncp;
                    return 1.0 / (x * helper(x, ncp));
                }
                ncp = -ncp;
            }
            double res = helper(x, ncp);
            return n < 0 ? (1.0 / res) : res;
        }

        double helper(double x, int n) {
            if (n == 1) return x;
            double res = helper(x, n / 2);
            res *= res;
            if ((n & 1) == 1) res *= x;
            return res;
        }
    }
}
