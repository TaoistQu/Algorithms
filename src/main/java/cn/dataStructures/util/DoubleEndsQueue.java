package cn.dataStructures.util;

/**
 * 双向链表实现双向添加删除元素
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/28 23:25
 */
public class DoubleEndsQueue<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail;

    /**
     * 从头上加元素
     *
     * @param value
     */
    public void addFromHead(T value) {
        DoubleNode<T> cur = new DoubleNode<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
    }

    /**
     * 从低端加元素
     *
     * @param value
     */
    public void addFromBottom(T value) {
        DoubleNode<T> cur = new DoubleNode<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            cur.last = tail;
            tail = cur;
        }
    }

    /**
     * 从顶段弹出元素
     *
     * @return
     */
    public T popFromHead() {
        if (head == null) {
            return null;
        }
        DoubleNode<T> cur = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.last = null;
            cur.next = null;
        }
        return cur.value;
    }

    /**
     * 从低端弹出元素
     *
     * @return
     */
    public T popFromBottom() {
        if (head == null)
            return null;
        DoubleNode<T> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            cur.last = null;
        }
        return cur.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
