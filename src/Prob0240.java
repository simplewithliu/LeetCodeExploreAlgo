package com.leetcode.explore;

/*

240. ������ά���� II

��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target ��
�þ�������������ԣ�
ÿ�е�Ԫ�ش������������С�
ÿ�е�Ԫ�ش��ϵ����������С�

ʾ�� 1��
���룺matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
�����true

ʾ�� 2��
���룺matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
�����false

��ʾ��
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matix[i][j] <= 10^9
ÿ�е�����Ԫ�ش�������������
ÿ�е�����Ԫ�ش��ϵ�����������
-10^9 <= target <= 10^9

*/

public class Prob0240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int i = 0, j = cols - 1;
            while (i < rows && j >= 0) {
                if (target > matrix[i][j]) ++i;
                else if (target < matrix[i][j]) --j;
                else break;
            }
            return i < rows && j >= 0;
        }
    }
}
