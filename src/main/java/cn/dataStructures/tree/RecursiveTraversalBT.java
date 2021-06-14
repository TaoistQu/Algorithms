package cn.dataStructures.tree;

import cn.dataStructures.tree.util.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 递归方式遍历二叉树
 * @Auther: TaoistQu
 * @Date: 2021/06/14/11:37
 */
public class RecursiveTraversalBT {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println("前序遍历===============================");
        pre(head);
        System.out.println();
        System.out.println("中序遍历================================");
        in(head);
        System.out.println();
        System.out.println("后序遍历=================================");
        pos(head);

    }

    /**
     * 实现二叉树的递归序
     *
     * @param head
     */
    public static void f(TreeNode head) {
        if (head == null) {
            return;
        }
        //1 这里打印为前序遍历
        System.out.println("前序遍历");
        f(head.left);
        //2 中序遍历
        System.out.println("中序遍历");
        f(head.right);
        //3
        System.out.println("后续遍历");
    }

    /**
     * 实现二叉树的前序遍历
     *
     * @param head
     */
    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    /**
     * 二叉树的中序遍历
     *
     * @param head
     */
    public static void in(TreeNode head) {
        if (head == null) return;
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    /**
     * 二叉树的后序遍历
     *
     * @param head
     */
    public static void pos(TreeNode head) {
        if (head == null) return;
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }


}
