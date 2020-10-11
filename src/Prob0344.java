package com.leetcode.explore;

/*

��ת�ַ���

��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���

ʾ�� 1��
���룺["h","e","l","l","o"]
�����["o","l","l","e","h"]

ʾ�� 2��
���룺["H","a","n","n","a","h"]
�����["h","a","n","n","a","H"]

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