package com.leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:
����: ["eat", "tea", "tan", "ate", "nat", "bat"]
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

˵����
���������ΪСд��ĸ��
�����Ǵ������˳��

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
