package cn.algorithms.dataStructures.mylist;

import java.util.ArrayList;

/**
 * 单链表反转
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/23 12:03
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(len, value);
            Node reverse1 = reverseLinkedList(node1);
            Node back1 = testReverseLinkedList(reverse1);
            if (!checkLinkedListEqual(node1, back1)) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("finish!");

    }

    /**
     * 逆转单链表
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node<Integer> head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 容器版的实现做对数器
     *
     * @param head
     * @return
     */
    public static Node testReverseLinkedList(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node<Integer>> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

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

    public static boolean checkLinkedListEqual(Node<Integer> head1, Node<Integer> head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }


    /**
     * 封装单链表节点
     *
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node next;

        public Node(T data) {
            value = data;
        }
    }
}
