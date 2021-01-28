package cn.dataStructures.mylist;

import cn.dataStructures.util.ListUtil;
import cn.dataStructures.util.Node;

/**
 * 删除链表中给定值
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/24 0:16
 */
public class DeleteGiveVale {
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        Node<Integer> node = ListUtil.generateRandomLinkedList(len, value);
        remove(node, 5);
    }
    /**
     * 删除单向链表中给定的值，返回删除后的链表头节点
     *
     * @param head 给定的单链表头节点
     * @param num  给定要删除的值
     * @return 删除后的链表头节点
     */
    public static Node<Integer> remove(Node<Integer> head, int num) {
        //让head先来到第一个不需要删出的位置
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node<Integer> pre = head;
        Node<Integer> cur = head;
        while (cur!=null){
            if(cur.value ==num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur =cur.next;
        }
        return head;
    }
}
