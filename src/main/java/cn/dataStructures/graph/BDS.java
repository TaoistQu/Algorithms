package cn.dataStructures.graph;

import cn.dataStructures.graph.util.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 图的深度优先遍历
 * @Auther: TaoistQu
 * @Date: 2021/07/17/22:20
 */
public class BDS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
