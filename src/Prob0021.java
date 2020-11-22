package com.leetcode.explore;

/*
 
合并两个有序链表

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

*/

public class Prob0021 {
	// 迭代
	class Solution1 {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			ListNode dummy = new ListNode(-1);
			ListNode pre = dummy;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					pre.next = l1;
					l1 = l1.next;
				} else {
					pre.next = l2;
					l2 = l2.next;
				}
				pre = pre.next;
			}
			if (l1 != null)
				pre.next = l1;
			else
				pre.next = l2;
			return dummy.next;
		}
	}

	// 递归
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			ListNode pHead = null;
			if (l1.val <= l2.val) {
				pHead = l1;
				pHead.next = mergeTwoLists(l1.next, l2);
			} else {
				pHead = l2;
				pHead.next = mergeTwoLists(l1, l2.next);
			}
			return pHead;
		}
	}
}
