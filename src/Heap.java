/**
 * Created by shuoshu on 2018/3/19.
 */
class Heap {
    int capacity;
    int[] nums;

    Heap() {
        nums = new int[100];
    }

    public void heapSort() {
        buildHeap();
        for (int i = capacity - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeap(0, i - 1);
        }
    }

    private void buildHeap() {
        for (int i = capacity / 2; i >= 0; i--) {
            adjustHeap(i, nums.length - 1);
        }
    }

    private void adjustHeap(int start, int end) {
        int lchild = 2 * start + 1, rChild = 2 * start + 2, largestIndex = start;
        if (lchild <= end && nums[lchild] > nums[largestIndex]) {
            largestIndex = lchild;
        }
        if (rChild <= end && nums[rChild] > nums[largestIndex]) {
            largestIndex = rChild;
        }

        if (start != largestIndex) {
            int temp = nums[start];
            nums[start] = nums[largestIndex];
            nums[largestIndex] = temp;
            adjustHeap(largestIndex, end);
        }
    }

    public void add(int n) {
        nums[capacity++] = n;
        adjustUp();
    }

    public int poll() {
        int val = nums[0];
        nums[0] = nums[--capacity];
        adjustHeap(0, capacity - 1);
        return val;
    }

    private void adjustUp() {
        int last = capacity - 1, parent = (last - 1) / 2;
        while (parent >= 0 && nums[parent] < nums[last]) {
            int temp = nums[parent];
            nums[parent] = nums[last];
            nums[last] = temp;
            last = parent;
            parent = (last - 1) / 2;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.add(5);
        heap.add(3);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}

