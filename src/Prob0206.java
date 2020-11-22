package com.leetcode.explore;

/*
 
��ת����

��תһ��������

ʾ��:
����: 1->2->3->4->5->NULL
���: 5->4->3->2->1->NULL

����:
����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿

*/

public class Prob0206 {
	// ����
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

	// �ݹ�
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
