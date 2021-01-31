package com.leetcode.explore;

import java.util.Stack;

/*

��Ч������

����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��

��Ч�ַ��������㣺
�����ű�������ͬ���͵������űպϡ�
�����ű�������ȷ��˳��պϡ�
 
ʾ�� 1��
���룺s = "()"
�����true

ʾ�� 2��
���룺s = "()[]{}"
�����true

ʾ�� 3��
���룺s = "(]"
�����false

ʾ�� 4��
���룺s = "([)]"
�����false

ʾ�� 5��
���룺s = "{[]}"
�����true
 
��ʾ��
1 <= s.length <= 104
s �������� '()[]{}' ���

*/

public class Prob0020 {
	class Solution {
		public boolean isValid(String s) {
			Stack<Character> stk = new Stack<>();
			for (char c : s.toCharArray()) {
				if (c == '(') stk.push(')');
				else if (c == '[') stk.push(']');
				else if (c == '{') stk.push('}');
				else if (stk.isEmpty() || stk.pop() != c) return false;
			}
			return stk.isEmpty();
		}
	}
}
