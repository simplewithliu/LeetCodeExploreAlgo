package com.leetcode.explore;

import java.util.Arrays;

/*

300. �����������

����һ���������� nums���ҵ�������ϸ���������еĳ��ȡ�

���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�

ʾ�� 1��
���룺nums = [10,9,2,5,3,7,101,18]
�����4
���ͣ�������������� [2,3,7,101]����˳���Ϊ4

ʾ�� 2��
���룺nums = [0,1,0,3,2,3]
�����4

ʾ�� 3��
���룺nums = [7,7,7,7,7,7,7]
�����1

��ʾ��
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4

���ף�
��������ʱ�临�Ӷ�ΪO(n2)�Ľ��������
���ܽ��㷨��ʱ�临�ӶȽ��͵�O(nlog(n))��?

*/

public class Prob0300 {
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[][] m = new int[len + 1][len];
            for (int[] arr : m) {
                Arrays.fill(arr, -1);
            }
            return helper(nums, -1, 0, m);
        }

        private int helper(int[] nums, int preIdx, int curIdx, int[][] m) {
            int len = nums.length;
            if (curIdx == len) return 0;
            if (m[preIdx + 1][curIdx] >= 0) return m[preIdx + 1][curIdx];
            int increNum = 0;
            if (preIdx < 0 || nums[curIdx] > nums[preIdx]) {
                increNum = 1 + helper(nums, curIdx, curIdx + 1, m);
            }
            int noIncreNum = helper(nums, preIdx, curIdx + 1, m);
            return m[preIdx + 1][curIdx] = Math.max(increNum, noIncreNum);
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int res = 0;
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }

    class Solution3 {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            int res = 0;
            for (int n : nums) {
                int lo = 0, hi = res;
                lo = biSearch(dp, lo, hi, n);
                if (lo == 0 || dp[lo - 1] < n) {
                    dp[lo] = n;
                    if (res == lo) ++res;
                }
            }
            return res;
        }

        // �൱�������������в���target���Ҳ����ͷ��������б�target�����Сֵ
        int biSearch(int[] nums, int lo, int hi, int target) {
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (target <= nums[mi]) hi = mi;
                else lo = mi + 1;
            }
            return lo;
        }
    }
}
