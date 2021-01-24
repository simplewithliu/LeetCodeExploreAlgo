package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

Fizz Buzz

дһ����������� 1 �� n ���ֵ��ַ�����ʾ
1. ��� n ��3�ı����������Fizz��
2. ��� n ��5�ı����������Buzz��
3. ��� n ͬʱ��3��5�ı�������� ��FizzBuzz��

ʾ����
n = 15,
����:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/

public class Prob0412 {
	
	class Solution1 {
		public List<String> fizzBuzz(int n) {
			List<String> res = new ArrayList<>();
			Map<Integer, String> dict = new TreeMap<>();
			dict.put(3, "Fizz");
			dict.put(5, "Buzz");
			for (int i = 1; i <= n; ++i) {
				String str = "";
				for (Integer k : dict.keySet()) {
					if (i % k == 0) {
						str += dict.get(k);
					}
				}
				if (str.equals("")) {
					str += String.valueOf(i);
				}
				res.add(str);
			}
			return res;
		}
	}

	// ���õĿ�ά����
	class Solution2 {
		public List<String> fizzBuzz(int n) {
			List<String> res = new ArrayList<>();
			Map<Integer, String> dict = new TreeMap<>();
			dict.put(3, "Fizz");
			dict.put(5, "Buzz");
			for (int i = 1; i <= n; ++i) {
				String str = "";
				for (Integer k : dict.keySet()) {
					if (i % k == 0) {
						str += dict.get(k);
					}
				}
				if (str.equals("")) {
					str += String.valueOf(i);
				}
				res.add(str);
			}
			return res;
		}
	}
}
