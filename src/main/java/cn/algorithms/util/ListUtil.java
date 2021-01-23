package cn.algorithms.util;

import cn.algorithms.dataStructures.mylist.DoubleNode;
import cn.algorithms.dataStructures.mylist.Node;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/24 0:30
 */
public class ListUtil {
    public static Node<Integer> generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node<Integer> head = new Node((int) (Math.random() * (value + 1)));
        Node<Integer> pre = head;
        while (size != 0) {
            Node<Integer> cur = new Node<>((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode<Integer> generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

}
