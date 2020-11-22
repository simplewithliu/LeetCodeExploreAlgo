package com.leetcode.explore;

/*

回文链表

请判断一个链表是否为回文链表

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

*/

public class Prob0234 {
	class Solution {
		public boolean isPalindrome(ListNode head) {
			if (head == null || head.next == null)
				return true;
			ListNode slow = head, fast = head;
			ListNode pre = null, rsePre = null;
			while (fast != null && fast.next != null) {
				pre = slow;
				slow = slow.next;
				fast = fast.next.next;
				pre.next = rsePre;
				rsePre = pre;
			}
			if (fast != null)
				slow = slow.next;
			while (pre != null && slow != null) {
				if (pre.val != slow.val)
					return false;
				pre = pre.next;
				slow = slow.next;
			}
			return true;
		}
	}
}
