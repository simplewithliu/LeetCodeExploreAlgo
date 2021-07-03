package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

56. �ϲ�����

������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [start_i, end_i]
����ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е���������

ʾ�� 1��
���룺intervals = [[1,3],[2,6],[8,10],[15,18]]
�����[[1,6],[8,10],[15,18]]
���ͣ����� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].

ʾ�� 2��
���룺intervals = [[1,4],[4,5]]
�����[[1,5]]
���ͣ����� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣

��ʾ��
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= start_i <= end_i <= 10^4

*/

public class Prob0056 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0].clone());
            for (int[] interval : intervals) {
                int[] tmp = res.get(res.size() - 1);
                if (interval[0] <= tmp[1]) {
                    tmp[1] = Math.max(interval[1], res.get(res.size() - 1)[1]);
                } else {
                    res.add(interval.clone());
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
