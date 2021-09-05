package cn.algorithms.recursion;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/09/05/16:01
 */
public class ReverseStackUsingRecursive {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);

        System.out.println("==========================");
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
