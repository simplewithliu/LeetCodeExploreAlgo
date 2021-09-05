package com.leetcode.explore;

import java.util.*;

/*

17. �绰�������ĸ���

����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰�����˳�򷵻ء�ע�� 1 ����Ӧ�κ���ĸ��

ʾ�� 1��
���룺digits = "23"
�����["ad","ae","af","bd","be","bf","cd","ce","cf"]

ʾ�� 2��
���룺digits = ""
�����[]

ʾ�� 3��
���룺digits = "2"
�����["a","b","c"]

��ʾ��
0 <= digits.length <= 4
digits[i] �Ƿ�Χ ['2', '9'] ��һ�����֡�

*/

public class Prob0017 {

    // �ݹ�
    class Solution1 {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>(Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) return res;
            helper(digits, list, res, new StringBuilder(), 0);
            return res;
        }

        void helper(String digits, List<String> list, List<String> res, StringBuilder sb, int idx) {
            if (idx == digits.length()) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < list.get(digits.charAt(idx) - '0').length(); ++i) {
                sb.append(list.get(digits.charAt(idx) - '0').charAt(i));
                helper(digits, list, res, sb, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // ����
    class Solution2 {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>(Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) return res;
            Queue<String> q = new LinkedList<>();
            q.offer("");
            while (q.peek().length() != digits.length()) {
                String temp = q.poll();
                String str = list.get(digits.charAt(temp.length()) - '0');
                for (int i = 0; i < str.length(); ++i) {
                    q.offer(temp + str.charAt(i));
                }
            }
            return (List<String>) q;
        }
    }
}
