package com.leetcode.explore;

/*

�ַ����еĵ�һ��Ψһ�ַ�
 
����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

ʾ����
s = "leetcode"
���� 0

s = "loveleetcode"
���� 2

��ʾ������Լٶ����ַ���ֻ����Сд��ĸ��

*/

public class Prob0387 {
	class Solution {
		public int firstUniqChar(String s) {
			if (s.isEmpty())
				return -1;
			char[] m = new char[26];
			for (int i = 0; i < s.length(); ++i) {
				++m[s.charAt(i) - 'a'];
			}
			for (int i = 0; i < s.length(); ++i) {
				if (m[s.charAt(i) - 'a'] == 1) {
					return i;
				}
			}
			return -1;
		}
	}
}
