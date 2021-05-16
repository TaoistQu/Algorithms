package cn.dataStructures.heap;

import cn.algorithms.util.ArrayUtil;
import cn.dataStructures.heap.util.HeapUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 大根堆 即为完全二叉树 任意一颗子树的最大值在树根上
 * <p>
 * i位置的节点的
 * 左子节点索引为：2*i+1
 * 右子节点索引坐标为：2*i+2
 * 父节点坐标为： (i-1)/2
 * </p>
 * @Auther: TaoistQu
 * @Date: 2021/05/15/19:18
 */
public class Heap {


    private int[] heap;
    private final int limit;
    private int heapSize;

    public Heap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        HeapUtil.heapInsert(heap, heapSize++);
    }

    public int pop() {
        int ans = heap[0];
        ArrayUtil.swap(heap, 0, --heapSize);
        HeapUtil.heapify(heap, 0, heapSize);
        return ans;
    }

}
