package cn.dataStructures.tree.recursive;

import cn.dataStructures.tree.util.TreeNode;
import cn.dataStructures.tree.util.TreeUtil;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 判断是否为完全二叉树
 * @Auther: TaoistQu
 * @Date: 2021/06/19/17:54
 */
public class IsCBT {
    /**
     * 按规则处理
     * 1)、如果出现右孩子，没左孩子肯定不是
     * 2)、出现左右孩子不全时，所有节点均要为叶子节点
     *
     * @param head
     * @return
     */
    public static boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                    (leaf && (l != null || r != null))
                            ||
                            (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCBT2(TreeNode head) {
        return process(head).isCBT;
    }

    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean fu, boolean cbt, int h) {
            isFull = fu;
            isCBT = cbt;
            height = h;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isCBT = isFull;
        if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
            isCBT = true;
        }
        return new Info(isFull, isCBT, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = TreeUtil.generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
