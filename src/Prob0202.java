package com.leetcode.explore;

/*

202. ������

��дһ���㷨���ж�һ���� n �ǲ��ǿ�������

����������Ϊ��
����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���͡�
Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ����������ѭ������ʼ�ձ䲻�� 1��
������Ա�Ϊ1����ô��������ǿ�������

���n�ǿ������ͷ���true�����ǣ��򷵻�false��

ʾ�� 1��
���룺19
�����true
���ͣ�
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

ʾ�� 2��
���룺n = 2
�����false

��ʾ��
1 <= n <= 2^31 - 1

*/

public class Prob0202 {
    class Solution {
        public boolean isHappy(int n) {
            int slow = n, fast = n;
            do {
                slow = bitSquareSum(slow);
                fast = bitSquareSum(bitSquareSum(fast));
            } while (slow != fast);
            return slow == 1;
        }

        private int bitSquareSum(int n) {
            int sum = 0;
            while (n > 0) {
                int cur = n % 10;
                sum += cur * cur;
                n /= 10;
            }
            return sum;
        }
    }
}
// https://leetcode.com/problems/happy-number/discuss/56919/Explanation-of-why-those-posted-algorithms-are-mathematically-valid



