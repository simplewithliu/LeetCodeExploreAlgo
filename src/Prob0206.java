package com.leetcode.explore;

/*
 
反转链表

反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

*/

public class Prob0206 {
	// 迭代
	class Solution1 {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return null;
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			reverse(dummy, null);
			return dummy.next;
		}

		private void reverse(ListNode head, ListNode behind) {
			ListNode start = head.next;
			ListNode then = start.next;
			ListNode pre = head;
			while (then != behind) {
				start.next = then.next;
				then.next = pre.next;
				pre.next = then;
				then = start.next;
			}
		}
	}

	// 递归
	class Solution2 {
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode preNode = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return preNode;
		}
	}
}
