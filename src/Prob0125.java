package com.leetcode.explore;

/*

��֤���Ĵ�

����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:
����: "A man, a plan, a canal: Panama"
���: true

ʾ�� 2:
����: "race a car"
���: false

*/

public class Prob0125 {
	class Solution {
		public boolean isPalindrome(String s) {
			if (s.isEmpty()) {
				return true;
			}
			for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
				while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
					++i;
				}
				while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
					--j;
				}
				if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				}
			}
			return true;
		}
	}
}
