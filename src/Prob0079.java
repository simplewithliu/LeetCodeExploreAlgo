package com.leetcode.explore;

/*

单词搜索

给定一个 m x n 二维字符网格board和一个字符串单词 word。如果 word 存在于网格中，返回true；否则，返回false。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true

示例 3：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false
 
提示：
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成

进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在board更大的情况下可以更快解决问题？

*/

public class Prob0079 {
	class Solution {
		public boolean exist(char[][] board, String word) {
			for (int i = 0; i < board.length; ++i) {
				for (int j = 0; j < board[0].length; ++j) {
					if (helper(board, i, j, word, 0)) return true;
				}
			}
			return false;
		}

		private boolean helper(char[][] board, int i, int j, String word, int index) {
			if (index == word.length()) return true;
			if (i == board.length || i < 0 || j < 0 || j == board[0].length || board[i][j] != word.charAt(index)) return false;
			board[i][j] = '*';
			boolean result = helper(board, i - 1, j, word, index + 1) || helper(board, i + 1, j, word, index + 1)
					|| helper(board, i, j - 1, word, index + 1) || helper(board, i, j + 1, word, index + 1);
			board[i][j] = word.charAt(index);
			return result;
		}
	}
}
