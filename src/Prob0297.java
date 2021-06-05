package com.leetcode.explore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

297. 二叉树的序列化与反序列化

序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例 1：
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[1,2]
 
提示：
树中结点数在范围 [0, 104] 内
-1000 <= Node.val <= 1000

*/

public class Prob0297 {
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			return serial(root, "");
		}

		private String serial(TreeNode node, String str) {
			if (node == null) {
				str += "#,";
				return str;
			} else {
				str += String.valueOf(node.val) + ",";
				str = serial(node.left, str);
				str = serial(node.right, str);
			}
			return str;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] dataArray = data.split(",");
			List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
			return deserial(dataList);
		}

		private TreeNode deserial(List<String> list) {
			if (list.get(0).equals("#")) {
				list.remove(0);
				return null;
			}
			TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
			list.remove(0);
			node.left = deserial(list);
			node.right = deserial(list);
			return node;
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec ser = new Codec();
	// Codec deser = new Codec();
	// TreeNode ans = deser.deserialize(ser.serialize(root));

}
