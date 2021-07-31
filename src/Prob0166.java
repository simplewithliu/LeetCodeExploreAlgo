package com.leetcode.explore;

import java.util.HashMap;
import java.util.Map;

/*

166. ������С��

���������������ֱ��ʾ�����ķ��� numerator �ͷ�ĸ denominator�����ַ�����ʽ����С�������С������Ϊѭ��С������ѭ���Ĳ�������������
������ڶ���𰸣�ֻ�践������һ��
�������и��������룬��֤���ַ����ĳ���С��10^4��

ʾ�� 1��
���룺numerator = 1, denominator = 2
�����"0.5"

ʾ�� 2��
���룺numerator = 2, denominator = 1
�����"2"

ʾ�� 3��
���룺numerator = 2, denominator = 3
�����"0.(6)"

ʾ�� 4��
���룺numerator = 4, denominator = 333
�����"0.(012)"

ʾ�� 5��
���룺numerator = 1, denominator = 5
�����"0.2"

��ʾ��
-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0

*/

public class Prob0166 {
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";
            StringBuilder fraction = new StringBuilder();
            if ((numerator > 0) ^ (denominator > 0)) {
                fraction.append("-");
            }
            // INT_MIN��������ô�������ͳһתΪ8�ֽ�����
            long dividend = Math.abs(Long.valueOf(numerator));
            long divisor = Math.abs(Long.valueOf(denominator));
            long remainder = dividend % divisor;
            fraction.append(String.valueOf(dividend / divisor));
            if (remainder == 0) return fraction.toString();
            fraction.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    fraction.insert(map.get(remainder), "(");
                    fraction.append(")");
                    break;
                }
                map.put(remainder, fraction.length());
                remainder *= 10;
                fraction.append(String.valueOf(remainder / divisor));
                remainder %= divisor;
            }
            return fraction.toString();
        }
    }
}
