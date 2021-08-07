package com.leetcode.explore;

import java.util.*;

/*

380. O(1) ʱ����롢ɾ���ͻ�ȡ���Ԫ��

���һ��֧����ƽ��ʱ�临�Ӷ� O(1) �£�ִ�����²��������ݽṹ��
insert(val)����Ԫ�� val ������ʱ���򼯺��в�����
remove(val)��Ԫ�� val ����ʱ���Ӽ������Ƴ����
getRandom������������м����е�һ�ÿ��Ԫ��Ӧ������ͬ�ĸ��ʱ����ء�

ʾ�� :
// ��ʼ��һ���յļ��ϡ�
RandomizedSet randomSet = new RandomizedSet();

// �򼯺��в��� 1 ������ true ��ʾ 1 ���ɹ��ز��롣
randomSet.insert(1);

// ���� false ����ʾ�����в����� 2 ��
randomSet.remove(2);

// �򼯺��в��� 2 ������ true ���������ڰ��� [1,2] ��
randomSet.insert(2);

// getRandom Ӧ������� 1 �� 2 ��
randomSet.getRandom();

// �Ӽ������Ƴ� 1 ������ true ���������ڰ��� [2] ��
randomSet.remove(1);

// 2 ���ڼ����У����Է��� false ��
randomSet.insert(2);

// ���� 2 �Ǽ�����Ψһ�����֣�getRandom ���Ƿ��� 2 ��
randomSet.getRandom();

*/

public class Prob0380 {
    class RandomizedSet {
        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;
            dict.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;
            int lastIdx = list.size() - 1;
            int removeIdx = dict.get(val);
            dict.put(list.get(lastIdx), removeIdx);
            list.set(removeIdx, list.get(lastIdx));
            list.remove(lastIdx);
            dict.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
