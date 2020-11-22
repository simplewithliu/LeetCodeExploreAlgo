package com.leetcode.explore;

/*

整数反转

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21

注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

*/

public class Prob0007 {
	class Solution {
		public int reverse(int x) {
			boolean sign = x < 0 ? true : false;
			int res = 0;
			while (x != 0) {
				if (sign) {
					if ((Integer.MIN_VALUE / 10 > res) || (Integer.MIN_VALUE / 10 == res && Integer.MIN_VALUE % 10 > x)) {
						return 0;
					}
				} else {
					if ((Integer.MAX_VALUE / 10 < res) || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < x)) {
						return 0;
					}
				}
				res = res * 10 + x % 10;
				x /= 10;
			}
			return res;
		}
	}
}