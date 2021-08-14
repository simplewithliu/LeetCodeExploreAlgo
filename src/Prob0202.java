package com.leetcode.explore;

/*

202. 快乐数

编写一个算法来判断一个数 n 是不是快乐数。

快乐数定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是无限循环，但始终变不到 1。
如果可以变为1，那么这个数就是快乐数。

如果n是快乐数就返回true；不是，则返回false。

示例 1：
输入：19
输出：true
解释：
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

示例 2：
输入：n = 2
输出：false

提示：
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



