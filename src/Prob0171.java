package com.leetcode.explore;

/*

171. Excel �������

����һ���ַ���columnTitle����ʾExcel����е������ơ����ظ������ƶ�Ӧ������š�

���磬

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

ʾ�� 1:
����: columnTitle = "A"
���: 1

ʾ�� 2:
����: columnTitle = "AB"
���: 28

ʾ�� 3:
����: columnTitle = "ZY"
���: 701

ʾ�� 4:
����: columnTitle = "FXSHRXW"
���: 2147483647

��ʾ��
1 <= columnTitle.length <= 7
columnTitle ���ɴ�дӢ�����
columnTitle �ڷ�Χ ["A", "FXSHRXW"] ��

*/

public class Prob0171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int res = 0;
            int mul = 1;
            for (int i = columnTitle.length() - 1; i >= 0; --i) {
                res += (columnTitle.charAt(i) - 'A' + 1) * mul;
                mul *= 26;
            }
            return res;
        }
    }
}
