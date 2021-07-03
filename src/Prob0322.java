package com.leetcode.explore;

import java.util.Arrays;

/*

��Ǯ�һ�

������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ����� -1��

�������Ϊÿ��Ӳ�ҵ����������޵ġ�

ʾ�� 1��
���룺coins = [1, 2, 5], amount = 11
�����3
���ͣ�11 = 5 + 5 + 1

ʾ�� 2��
���룺coins = [2], amount = 3
�����-1

ʾ�� 3��
���룺coins = [1], amount = 0
�����0

ʾ�� 4��
���룺coins = [1], amount = 1
�����1

ʾ�� 5��
���룺coins = [1], amount = 2
�����2

��ʾ��
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4

*/

public class Prob0322 {

    // ����¼
    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -2);
            return helper(coins, amount, memo);
        }

        private int helper(int[] coins, int amount, int[] memo) {
            if (amount == 0) return 0;
            if (memo[amount] != -2) return memo[amount];
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) continue;
                int sub = helper(coins, amount - coin, memo);
                if (sub == -1) continue;
                res = Math.min(res, sub + 1);
            }
            memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
            return memo[amount];
        }
    }

    // �Ե׶��϶�̬�滮
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; ++i) {
                for (int coin : coins) {
                    if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
