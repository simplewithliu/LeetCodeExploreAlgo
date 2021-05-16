package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
不考虑答案输出的顺序。

*/

public class Prob0049 {
	class Solution1 {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> m = new HashMap<>();
			for (String s : strs) {
				char[] array = s.toCharArray();
				Arrays.sort(array);
				String k = new String(array);
				List<String> v = m.getOrDefault(k, new ArrayList<String>());
				v.add(s);
				m.put(k, v);
			}
			return new ArrayList<List<String>>(m.values());
		}
	}

	class Solution2 {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> m = new HashMap<>();
			for (String s : strs) {
				int[] ch = new int[26];
				for (int i = 0; i < s.length(); ++i) ++ch[s.charAt(i) - 'a'];
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < 26; ++i) {
					if (ch[i] != 0) {
						sb.append((char) 'a' + i);
						sb.append(ch[i]);
					}
				}
				String k = sb.toString();
				List<String> v = m.getOrDefault(k, new ArrayList<String>());
				v.add(s);
				m.put(k, v);
			}
			return new ArrayList<List<String>>(m.values());
		}
	}
}
