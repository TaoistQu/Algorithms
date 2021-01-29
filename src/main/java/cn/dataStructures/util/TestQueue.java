package cn.dataStructures.util;

import cn.dataStructures.queue.RingArrayQueue;
import cn.dataStructures.stack.TwoQueueImplementStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/29 0:45
 */
public class TestQueue {
    public static void main(String[] args) {
        System.out.println("test begin");
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            //MyQueue<Integer> myQueue = new MyQueue<>();
            RingArrayQueue myQueue = new RingArrayQueue(10);

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
