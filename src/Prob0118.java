package com.leetcode.explore;

import java.util.ArrayList;
import java.util.List;

/*

�������

����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�

ʾ��:
����: 5
���:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

public class Prob0118 {
	class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> res = new ArrayList<>();
			for (int i = 0; i < numRows; ++i) {
				List<Integer> row = new ArrayList<>();
				for (int j = 0; j <= i; ++j) {
					if (j == 0 || j == i) row.add(1);
					else row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
				}
				res.add(row);
			}
			return res;
		}
	}
}
