package cn.dataStructures.util;

import cn.dataStructures.stack.TwoQueueImplementStack;

import java.util.Stack;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/29 23:34
 */
public class TestStack {
    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            // MyStack<Integer> myStack = new MyStack<>();
            TwoQueueImplementStack.TwoQueueStack<Integer> myStack =
                    new TwoQueueImplementStack.TwoQueueStack<>();
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
