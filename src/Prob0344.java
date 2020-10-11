package com.leetcode.explore;

/*

反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例 1：
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]

示例 2：
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

*/

public class Prob0344 {
	class Solution1 {
		public void reverseString(char[] s) {
			int len = s.length;
			for (int i = 0; i < len / 2; ++i) {
				char tmp = s[i];
				s[i] = s[len - i - 1];
				s[len - i - 1] = tmp;
			}
		}
	}

	class Solution2 {
		public void reverseString(char[] s) {
			int lo = 0, hi = s.length - 1;
			while (lo < hi) {
				s[lo] = (char) (s[lo] ^ s[hi]);
				s[hi] = (char) (s[lo] ^ s[hi]);
				s[lo] = (char) (s[lo] ^ s[hi]);
				++lo;
				--hi;
			}
		}
	}
}