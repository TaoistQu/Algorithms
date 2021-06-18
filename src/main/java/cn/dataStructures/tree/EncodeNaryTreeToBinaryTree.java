package cn.dataStructures.tree;

import cn.dataStructures.tree.util.NNode;
import cn.dataStructures.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 将一多叉树编码为二叉树，在进行序列化
 * @Auther: TaoistQu
 * @Date: 2021/06/18/23:42
 */
public class EncodeNaryTreeToBinaryTree {
    class Codec {
        //Encode an n-ary tree to a binary tree.
        public TreeNode encode(NNode root) {
            if (root == null) {
                return null;
            }
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }

        private TreeNode en(List<NNode> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (NNode child : children) {
                TreeNode tNode = new TreeNode(child.val);
                if (head == null) {
                    head = tNode;
                } else {
                    cur.right = tNode;
                }
                cur = tNode;
                cur.left = en(child.children);
            }
            return head;
        }

        /**
         * Decodes your binary tree to an n-ary tree.
         *
         * @param root
         * @return
         */
        public NNode decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new NNode(root.value, de(root.left));
        }

        private List<NNode> de(TreeNode root) {
            List<NNode> children = new ArrayList<>();
            while (root != null) {
                NNode cur = new NNode(root.value, de(root.left));
                children.add(cur);
                root = root.right;
            }
            return children;
        }
    }
}
