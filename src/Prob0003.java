package com.leetcode.explore;

/*
 
���ظ��ַ�����Ӵ�

����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�

ʾ�� 1:
����: s = "abcabcbb"
���: 3 
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��

ʾ�� 2:
����: s = "bbbbb"
���: 1
����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��

ʾ�� 3:
����: s = "pwwkew"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3����ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���

ʾ�� 4:
����: s = ""
���: 0

��ʾ��
0 <= s.length <= 5 * 104
s ��Ӣ����ĸ�����֡����źͿո����

*/

public class Prob0003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] dict = new int[128];
            int start = 0, end = 0, maxLen = 0, counter = 0;
            while (end < s.length()) {
                if (dict[s.charAt(end)] > 0) ++counter;
                ++dict[s.charAt(end)];
                ++end;
                while (counter > 0) {
                    if (dict[s.charAt(start)] > 1) --counter;
                    --dict[s.charAt(start)];
                    ++start;
                }
                maxLen = Math.max(maxLen, end - start);
            }
            return maxLen;
        }
    }
}
