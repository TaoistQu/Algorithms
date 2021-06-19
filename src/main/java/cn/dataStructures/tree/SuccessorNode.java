package cn.dataStructures.tree;

import cn.dataStructures.tree.util.PNode;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/19/15:54
 */
public class SuccessorNode {
    /**
     * @param args
     */
    public static void main(String[] args) {
        PNode head = new PNode(6);
        head.parent = null;
        head.left = new PNode(3);
        head.left.parent = head;
        head.left.left = new PNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new PNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new PNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new PNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new PNode(9);
        head.right.parent = head;
        head.right.left = new PNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new PNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new PNode(6);
        head.right.right.parent = head.right;

        PNode test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right;
        System.out.println(test.value + " next: " + (getSuccessorNode(test) == null ? null : getSuccessorNode(test).value));
    }

    /**
     * 找某一节点的后继节点
     *
     * @param node
     * @return
     */
    public static PNode getSuccessorNode(PNode node) {
        if (node == null) return node;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            PNode parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    private static PNode getLeftMost(PNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
