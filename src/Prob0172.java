package com.leetcode.explore;

/*

172. �׳˺����

����һ������ n������ n! ���β�������������

ʾ�� 1:
����: 3
���: 0
����: 3! = 6, β����û����

ʾ�� 2:
����: 5
���: 1
����: 5! = 120, β������ 1 ����

˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n)

*/

public class Prob0172 {
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while (n > 0) {
                res += n / 5;
                n /= 5;
            }
            return res;
        }
    }
}
