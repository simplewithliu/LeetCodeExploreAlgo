package com.leetcode.explore;

/*

50. Pow(x, n)

实现 pow(x, n) ，即计算 x 的 n 次幂函数（即 x^n）

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000

示例 2：
输入：x = 2.10000, n = 3
输出：9.26100

示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2^-2 = (1/2)^2 = 1/4 = 0.25

提示：
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

*/


public class Prob0050 {
    // 迭代
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

    // 递归
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
