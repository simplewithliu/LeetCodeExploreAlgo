package com.leetcode.explore;

import java.util.HashMap;
import java.util.Map;

/*

166. 分数到小数

给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数，如果小数部分为循环小数，则将循环的部分括在括号内
如果存在多个答案，只需返回任意一个
对于所有给定的输入，保证答案字符串的长度小于10^4。

示例 1：
输入：numerator = 1, denominator = 2
输出："0.5"

示例 2：
输入：numerator = 2, denominator = 1
输出："2"

示例 3：
输入：numerator = 2, denominator = 3
输出："0.(6)"

示例 4：
输入：numerator = 4, denominator = 333
输出："0.(012)"

示例 5：
输入：numerator = 1, denominator = 5
输出："0.2"

提示：
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
            // INT_MIN的情况不好处理，这里统一转为8字节整型
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
