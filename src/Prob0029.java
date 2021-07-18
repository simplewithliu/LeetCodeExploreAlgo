package com.leetcode.explore;

/*

29. 两数相除

给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。返回被除数dividend除以除数divisor得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为 32 位有符号整数。
除数不为0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-2^31, 2^31-1]。本题中，如果除法结果溢出，则返回 2^31 - 1

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
