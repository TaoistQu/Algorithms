package cn.dataStructures.tree.recursive;

import cn.dataStructures.tree.util.TreeNode;
import cn.dataStructures.tree.util.TreeUtil;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/21/23:05
 */
public class MaxSubBSTHead {
    public static int getBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arrayList) {
        if (head == null) {
            return;
        }
        in(head.left, arrayList);
        arrayList.add(head);
        in(head.right, arrayList);
    }

    public static TreeNode maxSubBSTHead1(TreeNode head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        TreeNode leftAns = maxSubBSTHead1(head.left);
        TreeNode rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    public static TreeNode maxSubBSTHead2(TreeNode head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    public static class Info {
        public TreeNode maxSubBSTHead;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(TreeNode h, int size, int mi, int ma) {
            maxSubBSTHead = h;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int min = x.value;
        int max = x.value;
        TreeNode maxSubBSTHead = null;
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTHead = rightInfo.maxSubBSTHead;
                maxSubBSTSize = rightInfo.maxSubBSTSize;
            }
        }
        if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == x.left && leftInfo.max < x.value))
                && (rightInfo == null ? true : (rightInfo.maxSubBSTHead == x.right && rightInfo.min > x.value))) {
            maxSubBSTHead = x;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
        }
        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = TreeUtil.generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
