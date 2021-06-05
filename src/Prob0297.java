package com.leetcode.explore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

297. �����������л��뷴���л�

���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�

�����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��

ʾ�� 1��
���룺root = [1,2,3,null,null,4,5]
�����[1,2,3,null,null,4,5]

ʾ�� 2��
���룺root = []
�����[]

ʾ�� 3��
���룺root = [1]
�����[1]

ʾ�� 4��
���룺root = [1,2]
�����[1,2]
 
��ʾ��
���н�����ڷ�Χ [0, 104] ��
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
