package cn.dataStructures.stack;

import cn.dataStructures.util.DoubleEndsQueue;

/**
 * 栈
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/28 22:40
 */
public class MyStack<T> {
    private DoubleEndsQueue<T> queue;

    public MyStack() {
        queue = new DoubleEndsQueue<>();
    }

    public void push(T value) {
        queue.addFromHead(value);
    }

    public T pop() {
        return queue.popFromHead();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

    }

}
