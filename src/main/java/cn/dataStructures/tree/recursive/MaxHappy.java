package cn.dataStructures.tree.recursive;

import cn.dataStructures.tree.util.NNode;
import cn.dataStructures.tree.util.TreeUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 派对的最大快乐值
 * 公司的每个员工都符合 Employee 类的描述。
 * 整个公司的人员结构可以看作是一棵标准的、 没有环的多叉树。
 * 树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。
 * 叶节点是没有任何下属的基层员工(subordinates列表为空)，除基层员工外，每个员工都有一个或多个直接下级。
 * <p>
 * 派对的最大快乐值
 * 这个公司现在要办party，你可以决定哪些员工来，哪些员工不来，规则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2.派对的整体快乐值是所有到场员工快乐值的累加
 * 3.你的目标是让派对的整体快乐值尽量大
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。
 * @Auther: TaoistQu
 * @Date: 2021/06/22/23:46
 */
public class MaxHappy {
    public static int maxHappy1(NNode boss) {
        if (boss == null) {
            return 0;
        }
        return process1(boss, false);
    }

    /**
     * 如果up为true，表示在cur上级已经确定来，的情况下，cur整棵树能够提供最大的快乐值是多少？
     * 如果up为false，表示在cur上级已经确定不来，的情况下，cur整棵树能够提供最大的快乐值是多少？
     *
     * @param cur 当前来到的节点叫
     * @param up  表示cur的上级是否来
     * @return
     */
    public static int process1(NNode cur, boolean up) {

        if (up) {
            int ans = 0;
            for (NNode next : cur.children) {
                ans += process1(next, false);
            }
            return ans;
        } else {
            int p1 = cur.val;
            int p2 = 0;
            for (NNode next : cur.children) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    public static int maxHappy2(NNode head) {
        Info allInfo = process(head);
        return Math.max(allInfo.no, allInfo.yes);
    }

    public static class Info {
        public int no;
        public int yes;

        public Info(int n, int y) {
            no = n;
            yes = y;
        }
    }

    public static Info process(NNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = x.val;
        for (NNode next : x.children) {
            Info nextInfo = process(next);
            no += Math.max(nextInfo.no, nextInfo.yes);
            yes += nextInfo.no;
        }
        return new Info(no, yes);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxNexts = 7;
        int maxValue = 100;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            NNode head = TreeUtil.genarateNTree(maxLevel, maxNexts, maxValue);
            if (maxHappy1(head) != maxHappy2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
