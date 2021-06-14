package cn.dataStructures.tree.util;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/05/21:30
 */
public class Node {
    public int pass;
    public int end;
    public HashMap<Integer, Node> nexts;

    public Node() {
        pass = 0;
        end = 0;
        nexts = new HashMap<>();
    }
}
