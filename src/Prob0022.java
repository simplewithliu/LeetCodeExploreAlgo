package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

22. 括号生成

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

提示：
1 <= n <= 8

*/

public class Prob0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(res, "", 0, 0, n);
        return res;
    }

    void help(List<String> res, String str, int left, int right, int parenNum) {
        if (str.length() == parenNum * 2) {
            res.add(str);
            return;
        }
        if (left < parenNum) help(res, str + "(", left + 1, right, parenNum);
        if (right < left) help(res, str + ")", left, right + 1, parenNum);
    }
}
