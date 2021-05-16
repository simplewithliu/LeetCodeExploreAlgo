package com.leetcode.explore;

/*

��������

����һ�� m x n ��ά�ַ�����board��һ���ַ������� word����� word �����������У�����true�����򣬷���false��
���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

ʾ�� 1��
���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
�����true

ʾ�� 2��
���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
�����true

ʾ�� 3��
���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
�����false
 
��ʾ��
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board �� word ���ɴ�СдӢ����ĸ���

���ף������ʹ��������֦�ļ������Ż����������ʹ����board���������¿��Ը��������⣿

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
