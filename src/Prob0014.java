package com.leetcode.explore;

/*

�����ǰ׺

��дһ�������������ַ��������е������ǰ׺����������ڹ���ǰ׺�����ؿ��ַ��� ""��

ʾ�� 1:
����: ["flower","flow","flight"]
���: "fl"

ʾ�� 2:
����: ["dog","racecar","car"]
���: ""
����: ���벻���ڹ���ǰ׺��

˵��:
��������ֻ����Сд��ĸ a-z ��

*/

public class Prob0014 {
	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0) {
				return "";
			}
			String pre = strs[0];
			for (int i = 1; i < strs.length; ++i) {
				int j = 0;
				while (j < pre.length() && j < strs[i].length()) {
					if (pre.charAt(j) != strs[i].charAt(j)) {
						break;
					} else {
						++j;
					}
				}
				pre = pre.substring(0, j);
				if (pre.equalsIgnoreCase("")) {
					return pre;
				}
			}
			return pre;
		}
	}
}
