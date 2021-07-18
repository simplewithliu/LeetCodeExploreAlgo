package com.leetcode.explore;

/*

371. ������֮��

��ʹ������� + �� - ������������ a ��b ֮�͡�

ʾ�� 1:
����: a = 1, b = 2
���: 3

ʾ�� 2:
����: a = -2, b = 3
���: 1

*/

public class Prob0371 {
    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a ^= b;
                b = c;
            }
            return a;
        }
    }
}
