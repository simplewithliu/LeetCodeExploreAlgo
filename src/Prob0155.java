package com.leetcode.explore;

import java.util.Stack;

/*

最小栈

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 
示例:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：
pop、top 和 getMin 操作总是在 非空栈 上调用。

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
