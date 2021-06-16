package cn.dataStructures.tree;

import cn.dataStructures.tree.util.TreeNode;
import cn.dataStructures.tree.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 序列化二叉树与反序列化树
 * <p>
 * <p>
 * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
 * 以下代码全部实现了。
 * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
 * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
 * 比如如下两棵树
 * __2
 * /
 * 1
 * 和
 * 1__
 * \
 * 2
 * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
 * @Auther: TaoistQu
 * @Date: 2021/06/14/22:41
 */
public class SerializeAndReconstructTree {
    /**
     * 前序序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> preSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(TreeNode head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    /**
     * 前序反序列化
     *
     * @param preList
     * @return
     */
    public static TreeNode buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    private static TreeNode preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }

    /**
     * 后序序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> posSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        poss(head, ans);
        return ans;
    }

    private static void poss(TreeNode head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            poss(head.left, ans);
            poss(head.right, ans);
            ans.add(String.valueOf(head.value));
        }
    }

    public static TreeNode buildByPosQueue(Queue<String> posList) {
        if (posList == null || posList.size() == 0) {
            return null;
        }
        // 左右中  ->  stack(中右左)
        Stack<String> stack = new Stack<>();
        while (!posList.isEmpty()) {
            stack.push(posList.poll());
        }
        return posb(stack);
    }

    private static TreeNode posb(Stack<String> posStack) {
        String value = posStack.pop();
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.right = posb(posStack);
        head.left = posb(posStack);
        return head;
    }

    /**
     * 用按层遍历的方式序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> levelSerial(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    /**
     * 按层遍历的方式反序列化
     *
     * @param levelList
     * @return
     */
    public static TreeNode buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.isEmpty()) {
            return null;
        }
        TreeNode head = generateNode(levelList.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    private static TreeNode generateNode(String value) {
        if (value == null) {
            return null;
        }
        return new TreeNode(Integer.valueOf(value));
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = TreeUtil.generateRandomBST(maxLevel, maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> pos = posSerial(head);
            Queue<String> level = levelSerial(head);
            TreeNode preBuild = buildByPreQueue(pre);
            TreeNode posBuild = buildByPosQueue(pos);
            TreeNode levelBuild = buildByLevelQueue(level);
            if (!TreeUtil.isSameValueStructure(preBuild, posBuild) || !TreeUtil.isSameValueStructure(posBuild, levelBuild)) {
                System.out.println("Oops!");
                TreeUtil.printTree(levelBuild);
                TreeUtil.printTree(preBuild);
                break;
            }
        }
        System.out.println("test finish!");
    }
}
