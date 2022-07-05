
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.PriorityQueue;

class Main {
    public int[] Heap;
    public int size;

    // constuctor
    Main() {
        this.Heap = new int[100];
        this.size = 0;
        Heap[0] = Integer.MIN_VALUE;
    }

    // for swapping element
    public void swap(int x, int y) {
        int temp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = temp;
    }

    // left child
    public int leftChild(int i) {
        // here I am starting heap from index 1 so left child is 2i;
        return 2 * i;
    }

    public int rightChild(int i) {
        // right child will be 2i +1
        return 2 * i + 1;
    }

    public int parent(int i) {
        return i / 2;
    }

    public void minHeapify(int i) {
        // check it is left node or not
        if (i > (size / 2)) {
            return;
        }
        // check smallest child index for particular element
        int smallest = Heap[leftChild(i)] < Heap[rightChild(i)] ? leftChild(i) : rightChild(i);
        // System.out.println("i: " + i + " smallest: " + smallest + " size" + size);
        // // minHeapify
        // System.out.println(Heap[i] > Heap[smallest]);
        if (Heap[i] > Heap[smallest]) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public void insert(int element) {
        // add element at the end of the array and increase the size of the heap
        Heap[++size] = element;
        int curr = size;
        // here check if parent of the currnode is less than the its parent or else swap
        // it with it parent do it until we all the element are satisfies minHeap
        // condition
        while (Heap[curr] < Heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    // getting min element in minHeap
    public int getMin() {
        if (size <= 0) {
            return -1;
        }
        // as I am starting with the index 1 I will return Heap[1] as it will be the
        // root node and smallest element in the heap array
        return Heap[1];
    }

    public int extractMin() {
        if (size <= 0) {
            return -1;
        }
        int popped = Heap[1];
        // get last element at root node and decrease the size of the heap;
        Heap[1] = Heap[size];
        size--;
        // heapify from root node
        minHeapify(1);
        // return popped element
        return popped;

    }

    // approch 1 using minHeap
    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            insert(num);
            if (size > k) {
                extractMin();
            }
        }
        return getMin();

    }

    // approch 2 using priorityQueue
    public int findKthLargest2(int[] nums, int k) {

        // by default min pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            // add element in pq
            pq.add(num);
            // if pq.size increase than k then remove root element from pq as it will
            // smallest element and we want to get kth largest element
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        Main main = new Main();
        System.out.println(main.findKthLargest(nums, k));
        System.out.println(main.findKthLargest2(nums, k));

    }
}