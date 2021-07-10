package com.leetcode.explore;

/*

200. ��������

����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
�������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
���⣬����Լ��������������߾���ˮ��Χ��

ʾ�� 1��
���룺grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
�����1

ʾ�� 2��
���룺grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
�����3

��ʾ��
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] ��ֵΪ '0' �� '1'

*/

import java.util.ArrayList;
import java.util.List;

public class Prob0200 {

    // DFS
    class Solution1 {
        public int numIslands(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int res = 0;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == '1') {
                        helper(grid, i, j, rows, cols);
                        res += 1;
                    }
                }
            }
            return res;
        }

        void helper(char[][] grid, int row, int col, int rows, int cols) {
            if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') return;
            grid[row][col] = '0';
            helper(grid, row - 1, col, rows, cols);
            helper(grid, row + 1, col, rows, cols);
            helper(grid, row, col - 1, rows, cols);
            helper(grid, row, col + 1, rows, cols);
        }
    }

    // ���鼯
    class Solution2 {
        public int numIslands(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            UF uf = new UF(grid, rows, cols);
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == '1') {
                        int p = i * cols + j;
                        if (j < cols - 1 && grid[i][j + 1] == '1') {
                            int q = i * cols + j + 1;
                            uf.union(p, q);
                        }
                        if (i < rows - 1 && grid[i + 1][j] == '1') {
                            int q = (i + 1) * cols + j;
                            uf.union(p, q);
                        }
                    }
                }
            }
            return uf.getCount();
        }
    }

    class UF {
        private int[] id;
        private int count = 0;

        public UF(char[][] grid, int rows, int cols) {
            id = new int[rows * cols];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == '1') {
                        id[i * cols + j] = i * cols + j;
                        ++count;
                    } else {
                        id[i * cols + j] = -1;
                    }
                }
            }
        }

        public int find(int x) {
            if (id[x] != x) id[x] = find(id[x]);
            return id[x];
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            id[pRoot] = qRoot;
            --count;
        }

        public int getCount() {
            return count;
        }
    }
}
