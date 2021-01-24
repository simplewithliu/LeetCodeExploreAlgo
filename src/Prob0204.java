package com.leetcode.explore;

/*

计数质数

统计所有小于非负整数 n 的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0
 
提示：
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
