package cn.dataStructures.tree.recursive;

import cn.dataStructures.tree.util.TreeNode;
import cn.dataStructures.tree.util.TreeUtil;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 给定一棵二叉树的头节点head，和另外两个节点a和b。
 * 返回a和b的最低公共祖先
 * @Auther: TaoistQu
 * @Date: 2021/06/22/0:06
 */
public class LowestAncestor {

    public static TreeNode lowestAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(head, null);
        filParentMap(head, parentMap);
        HashSet<TreeNode> o1Set = new HashSet<>();
        TreeNode cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void filParentMap(TreeNode head, HashMap<TreeNode, TreeNode> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            filParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            filParentMap(head.right, parentMap);
        }
    }

    public static TreeNode lowestAncestor2(TreeNode head, TreeNode a, TreeNode b) {
        return process(head, a, b).ans;
    }

    public static class Info {
        public boolean findA;
        public boolean findB;
        public TreeNode ans;

        public Info(boolean fa, boolean fb, TreeNode an) {
            findA = fa;
            findB = fb;
            ans = an;
        }
    }

    public static Info process(TreeNode x, TreeNode a, TreeNode b) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);
        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
        TreeNode ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        } else if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        } else {
            if (findA && findB) {
                ans = x;
            }
        }
        return new Info(findA, findB, ans);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = TreeUtil.generateRandomBST(maxLevel, maxValue);
            TreeNode a = TreeUtil.pickRandomOne(head);
            TreeNode b = TreeUtil.pickRandomOne(head);
            if (lowestAncestor1(head, a, b) != lowestAncestor2(head, a, b)) {
                System.out.println("Oops!!!");
            }
        }
        System.out.println("finish!");
    }


}
