package com.leetcode.explore;

/*

69. x ��ƽ����

ʵ�� int sqrt(int x) ������
���㲢���� x ��ƽ���������� x �ǷǸ�������
���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��

ʾ�� 1:
����: 4
���: 2

ʾ�� 2:
����: 8
���: 2
˵��: 8 ��ƽ������ 2.82842..., ���ڷ���������������С�����ֽ�����ȥ��

*/

public class Prob0069 {
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            int lo = 1;
            int hi = x;
            while (lo < hi) {
                int mi = lo + (hi - lo + 1) / 2;
                if (mi > x / mi) hi = mi - 1;
                else lo = mi;
            }
            return lo;
        }
    }
}
