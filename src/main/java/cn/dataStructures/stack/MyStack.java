package cn.dataStructures.stack;

import cn.dataStructures.util.CompareUtil;
import cn.dataStructures.util.DoubleEndsQueue;

import java.util.Stack;

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
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (myStack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!CompareUtil.isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                }
            }
        System.out.println("finish!!!");
    }

}
