package cn.dataStructures.mylist;

import cn.dataStructures.util.ListUtil;
import cn.dataStructures.util.Node;

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
            Node node1 = ListUtil.generateRandomLinkedList(len, value);
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

    public static boolean checkLinkedListEqual(Node<Integer> head1, Node<Integer> head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

}
