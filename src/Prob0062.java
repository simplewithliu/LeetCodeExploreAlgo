package com.leetcode.explore;

import java.util.Arrays;

/*

62. ��ͬ·��

һ��������λ��һ�� m x n ��������Ͻ�
������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½�
���ܹ��ж�������ͬ��·����

ʾ�� 1��
���룺m = 3, n = 7
�����28

ʾ�� 2��
���룺m = 3, n = 2
�����3
���ͣ�
�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
1. ���� -> ���� -> ����
2. ���� -> ���� -> ����
3. ���� -> ���� -> ����

ʾ�� 3��
���룺m = 7, n = 3
�����28

ʾ�� 4��
���룺m = 3, n = 3
�����6

��ʾ��
1 <= m, n <= 100
��Ŀ���ݱ�֤��С�ڵ��� 2 * 10^9

*/

public class Prob0062 {
    // ����¼
    class Solution1 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[][] memo = new int[m + 1][n + 1];
            return helper(m, n, memo);
        }

        int helper(int m, int n, int[][] memo) {
            if (m == 1 || n == 1) return 1;
            if (memo[m][n] > 0) return memo[m][n];
            return memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
        }
    }

    // �Ե׶��ϵĶ�̬�滮
    class Solution2 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; ++i) dp[i][0] = 1;
            for (int j = 0; j < n; ++j) dp[0][j] = 1;
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    // �ռ��Ż�
    class Solution3 {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) return 0;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
}
