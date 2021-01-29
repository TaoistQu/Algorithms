package cn.dataStructures.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列实现栈
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/28 22:51
 */
public class TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        /**
         * 添加元素
         *
         * @param value
         */
        public void push(T value) {
            queue.offer(value);
        }

        /**
         * 获取元素
         *
         * @return
         */
        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        /**
         * 获取peek
         *
         * @return
         */
        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        /**
         * 判断栈是不是空
         *
         * @return
         */
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }


}
