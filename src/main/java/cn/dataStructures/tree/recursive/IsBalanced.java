package cn.dataStructures.tree.recursive;

import cn.dataStructures.tree.util.TreeNode;
import cn.dataStructures.tree.util.TreeUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/20/16:24
 */
public class IsBalanced {
    public static boolean isBalanced1(TreeNode head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(TreeNode head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    /**
     * 用递归套路实现的判断
     *
     * @param head
     * @return
     */
    public static boolean isBalanced2(TreeNode head) {
        return process(head).isBalanced;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        boolean isBalanced = true;
        if (!leftInfo.isBalanced) {
            isBalanced = false;
        }
        if (!rightInfo.isBalanced) {
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = TreeUtil.generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
