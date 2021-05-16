package com.leetcode.explore;

/*
 
��ż����

����һ�������������е������ڵ��ż���ڵ�ֱ�����һ��

��ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�

�볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������

ʾ�� 1:
����: 1->2->3->4->5->NULL
���: 1->3->5->2->4->NULL

ʾ�� 2:
����: 2->1->3->5->6->4->7->NULL 
���: 2->3->6->7->1->5->4->NULL

˵��:
Ӧ�����������ڵ��ż���ڵ�����˳��
����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�

*/

public class Prob0328 {
	class Solution {
		public ListNode oddEvenList(ListNode head) {
			if (head == null) return head;
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHead = even;
			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
			return head;
		}
	}
}
