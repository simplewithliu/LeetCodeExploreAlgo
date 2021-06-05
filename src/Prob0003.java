package com.leetcode.explore;

/*
 
无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

示例 4:
输入: s = ""
输出: 0

提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

*/

public class Prob0003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] dict = new int[128];
            int start = 0, end = 0, maxLen = 0, counter = 0;
            while (end < s.length()) {
                if (dict[s.charAt(end)] > 0) ++counter;
                ++dict[s.charAt(end)];
                ++end;
                while (counter > 0) {
                    if (dict[s.charAt(start)] > 1) --counter;
                    --dict[s.charAt(start)];
                    ++start;
                }
                maxLen = Math.max(maxLen, end - start);
            }
            return maxLen;
        }
    }
}
