package cn.dataStructures.tree.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/18/23:47
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {
    }

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
