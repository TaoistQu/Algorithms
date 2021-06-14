package cn.dataStructures.tree;

import cn.dataStructures.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 二叉树按层遍历
 * @Auther: TaoistQu
 * @Date: 2021/06/14/18:39
 */
public class LevelTraversalBT {
    public static void level(TreeNode head) {
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        level(head);
    }
}
