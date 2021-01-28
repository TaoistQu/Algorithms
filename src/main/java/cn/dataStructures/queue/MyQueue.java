package cn.dataStructures.queue;

import cn.dataStructures.util.CompareUtil;
import cn.dataStructures.util.DoubleEndsQueue;

import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyQueue<Integer> myQueue = new MyQueue<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int numq = (int) (Math.random() * value);
                if (myQueue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!CompareUtil.isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
