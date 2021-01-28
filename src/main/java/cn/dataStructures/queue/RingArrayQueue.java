package cn.dataStructures.queue;

/**
 * 用循环数组实现队列
 * 技巧使用一个size来控制begin和end之间的距离，从而避免判断边界
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/29 0:29
 */
public class RingArrayQueue {
    private int[] arr;
    private int pushi; //end
    private int polli; //begin
    private int size;
    private final int limit;//队列容量

    public RingArrayQueue(int limit) {
        this.limit = limit;
        arr = new int[limit];
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("队列已满，不能再加了！！！");
        }
        size++;
        arr[pushi] = value;
        pushi = nextIndex(pushi);
    }

    public int poll() {
        if (size == 0)
            throw new RuntimeException("队列已空，不能再拿了！！！");
        size--;
        int ans = arr[polli];
        polli = nextIndex(polli);
        return ans;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 实现获取下一个位置的索引坐标,如果到最大值位置，让其到0
     *
     * @param i
     * @return
     */
    public int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }


}
