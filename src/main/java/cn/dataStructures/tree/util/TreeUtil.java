package cn.dataStructures.tree.util;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/16/23:15
 */
public class TreeUtil {
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static TreeNode generate(int level, int maxLevel, int maxvalue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxvalue));
        head.left = generate(level + 1, maxLevel, maxvalue);
        head.right = generate(level + 1, maxLevel, maxvalue);
        return head;
    }

    public static TreeNode pickRandomOne(TreeNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        filPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    public static void filPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        filPrelist(head.left, arr);
        filPrelist(head.right, arr);
    }

    public static boolean isSameValueStructure(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 != null && head2 == null) return false;
        if (head1 == null && head2 != null) return false;
        if (head1.value != head2.value) return false;
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        System.out.println(getSpace(height + len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    /**
     * 随机构建多叉树
     *
     * @param maxLevel
     * @param maxNexts
     * @param maxValue
     * @return
     */
    public static NNode genarateNTree(int maxLevel, int maxNexts, int maxValue) {
        if (Math.random() < 0.02) {
            return null;
        }
        NNode head = new NNode((int) (Math.random() * (maxValue + 1)), new ArrayList<>());
        genarateNexts(head, 1, maxLevel, maxNexts, maxValue);
        return head;
    }

    public static void genarateNexts(NNode head, int level, int maxLevel, int maxNexts, int maxValue) {
        if (level > maxLevel) {
            return;
        }
        int nextsSize = (int) (Math.random()) * (maxNexts + 1);
        for (int i = 0; i < nextsSize; i++) {
            NNode next = new NNode((int) (Math.random() * (maxValue + 1)), new ArrayList<>());
            head.children.add(next);
            genarateNexts(next, level + 1, maxLevel, maxNexts, maxValue);
        }
    }

}
