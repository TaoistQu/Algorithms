package cn.dataStructures.tree;

import cn.dataStructures.tree.util.Node;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/05/21:29
 */
public class TrieTreeHash {
    private Node root;

    public TrieTreeHash() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        Node node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = (int) chs[i];
            if (!node.nexts.containsKey(index)) {
                node.nexts.put(index, new Node());
            }
            node = node.nexts.get(index);
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            Node node = root;
            node.pass--;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (--node.nexts.get(index).pass == 0) {
                    node.nexts.remove(index);
                    return;
                }
                node = node.nexts.get(index);
            }
            node.end--;
        }
    }

    public int search(String word) {
        if (word == null)
            return 0;
        char[] chs = word.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = (int) chs[i];
            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.end;
    }

    public int prefixNumber(String word) {
        if (word == null) return 0;
        char[] chs = word.toCharArray();
        int index = 0;
        Node node = root;
        for (int i = 0; i < chs.length; i++) {
            index = (int) chs[i];
            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
    }
}
