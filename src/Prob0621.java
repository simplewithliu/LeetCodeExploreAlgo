package com.leetcode.explore;

import java.util.*;

/*

621. ���������

����һ�����ַ����� tasks ��ʾ�� CPU ��Ҫִ�е������б�����ÿ����ĸ��ʾһ�ֲ�ͬ���������
�������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣ
���κ�һ����λʱ�䣬CPU �������һ�����񣬻��ߴ��ڴ���״̬��
Ȼ����������ͬ���������֮������г���Ϊ���� n ����ȴʱ�䣬������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��
����Ҫ�������������������Ҫ�����ʱ�� ��

ʾ�� 1��
���룺tasks = ["A","A","A","B","B","B"], n = 2
�����8
���ͣ�A -> B -> (����) -> A -> B -> (����) -> A -> B
     �ڱ�ʾ���У�������ͬ��������֮�����������Ϊ n = 2 ����ȴʱ�䣬��ִ��һ������ֻ��Ҫһ����λʱ�䣬�����м�����ˣ�������״̬��

ʾ�� 2��
���룺tasks = ["A","A","A","B","B","B"], n = 0
�����6
���ͣ�����������£��κδ�СΪ 6 �����ж���������Ҫ����Ϊ n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
�������

ʾ�� 3��
���룺tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
�����16
���ͣ�һ�ֿ��ܵĽ�������ǣ�
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (����) -> (����) -> A -> (����) -> (����) -> A


��ʾ��
1 <= task.length <= 10^4
tasks[i] �Ǵ�дӢ����ĸ
n ��ȡֵ��ΧΪ [0, 100]

*/

public class Prob0621 {
    // ���ȼ�����
    class Solution1 {
        public int leastInterval(char[] tasks, int n) {
            int[] m = new int[26];
            for (char c : tasks) ++m[c - 'A'];
            Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i : m) {
                if (i > 0) pq.offer(i);
            }
            int times = 0;
            while (!pq.isEmpty()) {
                int i = 0;
                List<Integer> temp = new ArrayList<>();
                while (i <= n) {
                    if (!pq.isEmpty()) {
                        if (pq.peek() > 1) {
                            temp.add(pq.peek() - 1);
                            pq.poll();
                        } else {
                            pq.poll();
                        }
                    }
                    ++times;
                    if (pq.isEmpty() && temp.isEmpty()) break;
                    ++i;
                }
                for (int t : temp) pq.offer(t);
            }
            return times;
        }
    }

    // ��Ͱ��
    class Solution2 {
        public int leastInterval(char[] tasks, int n) {
            int[] m = new int[26];
            for (char c : tasks) ++m[c - 'A'];
            Arrays.sort(m);
            int maxVal = m[25] - 1;
            int idle = maxVal * n;
            for (int i = 24; i >= 0 && m[i] > 0; --i) {
                idle -= Math.min(m[i], maxVal);
            }
            return idle > 0 ? idle + tasks.length : tasks.length;
        }
    }
}

