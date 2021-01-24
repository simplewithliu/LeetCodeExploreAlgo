package com.leetcode.explore;

import java.util.Stack;

/*

��Сջ

���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
push(x) ���� ��Ԫ�� x ����ջ�С�
pop() ���� ɾ��ջ����Ԫ�ء�
top() ���� ��ȡջ��Ԫ�ء�
getMin() ���� ����ջ�е���СԪ�ء�
 
ʾ��:
���룺
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
�����
[null,null,null,null,-3,null,0,-2]

���ͣ�
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> ���� -3.
minStack.pop();
minStack.top();      --> ���� 0.
minStack.getMin();   --> ���� -2.
 

��ʾ��
pop��top �� getMin ���������� �ǿ�ջ �ϵ��á�

*/


public class Prob0155 {
	class MinStack {

		private Stack<Integer> data;
		private Stack<Integer> min;

		/** initialize your data structure here. */
		public MinStack() {
			data = new Stack<>();
			min = new Stack<>();
		}

		public void push(int x) {
			data.add(x);
			if (min.isEmpty() || min.peek() >= x) {
				min.add(x);
			}
		}

		public void pop() {
			if (!data.isEmpty()) {
				int top = data.pop();
				if (top == min.peek()) {
					min.pop();
				}
			}
		}

		public int top() {
			if (!data.isEmpty())
				return data.peek();
			throw new RuntimeException("stack empty!");
		}

		public int getMin() {
			if (!min.isEmpty())
				return min.peek();
			throw new RuntimeException("stack empty!");
		}
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

}
