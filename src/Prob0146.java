package com.leetcode.explore;

import java.util.HashMap;
import java.util.Map;

/*

146. LRU ����

������Ʋ�ʵ��һ������ LRU (�������ʹ��) ���� Լ�������ݽṹ��

ʵ�� LRUCache �ࣺ

LRUCache(int capacity) �� ������ ��Ϊ���� capacity ��ʼ�� LRU ����
int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
void put(int key, int value) ����ؼ��� key �Ѿ����ڣ�����������ֵ value ����������ڣ����򻺴��в������ key-value ��
�������������¹ؼ����������� capacity ����Ӧ�� ��� ���δʹ�õĹؼ��֡�

���� get �� put ������ O(1) ��ƽ��ʱ�临�Ӷ����С�

ʾ����
����
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
���
[null, null, null, 1, null, -1, null, -1, 3, 4]

����
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // ������ {1=1}
lRUCache.put(2, 2); // ������ {1=1, 2=2}
lRUCache.get(1);    // ���� 1
lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
lRUCache.get(2);    // ���� -1 (δ�ҵ�)
lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
lRUCache.get(1);    // ���� -1 (δ�ҵ�)
lRUCache.get(3);    // ���� 3
lRUCache.get(4);    // ���� 4

��ʾ��
1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 10^5
������ 2 * 10^5 �� get �� put

*/

public class Prob0146 {
    class LRUCache {

        Node head;
        Node tail;
        Map<Integer, Node> m = new HashMap<>();
        int cap;

        public LRUCache(int capacity) {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (m.containsKey(key)) {
                Node node = m.get(key);
                remove(node);
                insert(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (m.containsKey(key)) {
                remove(m.get(key));
            }
            if (m.size() == cap) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }

        private void remove(Node node) {
            m.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            m.put(node.key, node);
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
        }

        private class Node {
            Node prev;
            Node next;
            int key;
            int val;

            public Node(int k, int v) {
                key = k;
                val = v;
            }
        }
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
