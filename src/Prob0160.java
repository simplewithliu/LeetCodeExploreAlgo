package com.leetcode.explore;

/*

�ཻ����

��дһ�������ҵ������������ཻ����ʼ�ڵ㡣

ʾ�� 1��
���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
�����Reference of the node with value = 8
������ͣ��ཻ�ڵ��ֵΪ 8��ע�⣬������������ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]��
��A�У��ཻ�ڵ�ǰ��2���ڵ㣻��B�У��ཻ�ڵ�ǰ��3���ڵ㡣
 

ʾ�� 2��
���룺intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
�����Reference of the node with value = 2
������ͣ��ཻ�ڵ��ֵΪ 2 ��ע�⣬������������ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [0,9,1,2,4]������ B Ϊ [3,2,4]��
�� A �У��ཻ�ڵ�ǰ�� 3 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 1 ���ڵ㡣
 

ʾ�� 3��
���룺intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
�����null
������ͣ��Ӹ��Եı�ͷ��ʼ�������� A Ϊ [2,6,4]������ B Ϊ [1,5]�����������������ཻ������ intersectVal ����Ϊ 0���� skipA �� skipB ����������ֵ��
���ͣ������������ཻ����˷��� null��
 

ע�⣺
�����������û�н��㣬���� null.
�ڷ��ؽ���������������뱣��ԭ�еĽṹ��
�ɼٶ���������ṹ��û��ѭ����
���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档


*/

public class Prob0160 {
	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode p1 = headA, p2 = headB;
			while (p1 != p2) {
				p1 = (p1 == null) ? headB : p1.next;
				p2 = (p2 == null) ? headA : p2.next;
			}
			return p1;
		}
	}
}
