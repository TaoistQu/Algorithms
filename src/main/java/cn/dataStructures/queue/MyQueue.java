package cn.dataStructures.queue;

import cn.dataStructures.util.DoubleEndsQueue;

/**
 * 队列
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/28 22:24
 */
public class MyQueue<T> {
    private DoubleEndsQueue<T> queue;
    public MyQueue() {
        queue = new DoubleEndsQueue<>();
    }
    public void push(T value) {
        queue.addFromHead(value);
    }
    public T poll() {
        return queue.popFromBottom();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
