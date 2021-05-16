package cn.dataStructures.heap;

import cn.algorithms.util.ArrayUtil;
import cn.dataStructures.heap.util.HeapUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 大根堆
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
