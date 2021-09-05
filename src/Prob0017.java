package com.leetcode.explore;

import java.util.*;

/*

17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。注意 1 不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]

提示：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

*/

public class Prob0017 {

    // 递归
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

    // 迭代
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
