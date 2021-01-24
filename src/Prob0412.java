package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

Fizz Buzz

写一个程序，输出从 1 到 n 数字的字符串表示
1. 如果 n 是3的倍数，输出“Fizz”
2. 如果 n 是5的倍数，输出“Buzz”
3. 如果 n 同时是3和5的倍数，输出 “FizzBuzz”

示例：
n = 15,
返回:
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

	// 更好的可维护性
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
