package com.leetcode.explore;

import java.util.Random;

/*

169. ����Ԫ��

����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�

ʾ�� 1��
���룺[3,2,3]
�����3

ʾ�� 2��
���룺[2,2,1,1,1,2,2]
�����2

���ף�
�������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ���㷨��������⡣

*/

public class Prob0169 {
    // ���ٻ���
    class Solution1 {
        public int majorityElement(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            int mi = nums.length / 2;
            int idx = partition(nums, lo, hi);
            while (idx != mi) {
                if (idx > mi) {
                    hi = idx - 1;
                    idx = partition(nums, lo, hi);
                } else {
                    lo = idx + 1;
                    idx = partition(nums, lo, hi);
                }
            }
            return nums[mi];
        }

        private int partition(int[] nums, int lo, int hi) {
            int pivotIdx = new Random().nextInt(hi - lo + 1) + lo;
            int pivot = nums[pivotIdx];
            nums[pivotIdx] = nums[lo];
            nums[lo] = pivot;
            while (lo < hi) {
                while (lo < hi) {
                    if (pivot < nums[hi]) {
                        --hi;
                    } else {
                        nums[lo++] = nums[hi];
                        break;
                    }
                }
                while (lo < hi) {
                    if (pivot > nums[lo]) {
                        ++lo;
                    } else {
                        nums[hi--] = nums[lo];
                        break;
                    }
                }
            }
            nums[lo] = pivot;
            return lo;
        }
    }

    // Ħ��ͶƱ
    class Solution2 {
        public int majorityElement(int[] nums) {
            int cur = nums[0];
            int times = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (times == 0) {
                    cur = nums[i];
                    times = 1;
                } else if (nums[i] == cur) {
                    ++times;
                } else {
                    --times;
                }
            }
            return cur;
        }
    }
}
