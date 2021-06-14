package cn.dataStructures.tree;

import cn.dataStructures.tree.util.Node1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用数组的方式实现前缀树
 * @Auther: TaoistQu
 * @Date: 2021/06/05/21:11
 */
public class TrieTree {
    private Node1 root;

    public TrieTree() {
        root = new Node1();
    }

    /**
     * 向前缀树中添加元素
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        Node1 node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node1();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            Node1 node = root;
            node.pass--;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    public int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] chs = word.toCharArray();
        Node1 node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chs = pre.toCharArray();
        Node1 node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }
}
