package cn.dataStructures.tree;

import cn.dataStructures.tree.util.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 非递归的方式进行二叉树的遍历
 * @Auther: TaoistQu
 * @Date: 2021/06/14/12:05
 */
public class UnRecursiveTraversalBT {
    /**
     * 前序方式遍历二叉树
     *
     * @param head
     */
    public static void pre(TreeNode head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     *
     * @param cur
     */
    public static void in(TreeNode cur) {
        System.out.println("in-order: ");
        if (cur != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 用两个栈实现后续遍历
     *
     * @param head
     */
    public static void pos1(TreeNode head) {
        System.out.println("pos-order: ");
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head); // 头 右 左
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 用一个栈实现二叉树后序遍历
     *
     * @param h
     */
    public static void pos2(TreeNode h) {
        System.out.println("pos-order: ");
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pre(head);
        in(head);
        pos1(head);
        pos2(head);

    }
}
