package cn.dataStructures.list;

import cn.dataStructures.util.DoubleNode;
import cn.dataStructures.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转双向链表
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/23 12:22
 */
public class ReverseDoubleList {
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for(int i =0;i<testTime;i++) {
            DoubleNode node3 = ListUtil.generateRandomDoubleList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

            DoubleNode node4 = ListUtil.generateRandomDoubleList(len, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseDoubleList(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("Oops4!");
            }
        }
        System.out.println("test finish!");
    }

    /**
     * 倒转双向链表
     *
     * @param head 双向链表头节点
     * @return 返回倒转后的头节点
     */
    public static DoubleNode<Integer> reverseDoubleList(DoubleNode<Integer> head) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode<Integer> testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 0; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }

    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode<Integer> head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }
    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode<Integer> head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

}
