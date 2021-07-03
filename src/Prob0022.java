package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

22. ��������

���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ�����Ч��������ϡ�

ʾ�� 1��
���룺n = 3
�����["((()))","(()())","(())()","()(())","()()()"]

ʾ�� 2��
���룺n = 1
�����["()"]

��ʾ��
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
