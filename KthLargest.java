// Time complexity: O(nlog(k))
// Space complexity: O(k)

// Approach: Used min heap of size k. Whenever heap is full,
// the next element can't be one of the k largest as there are k
// bigger numbers than that in the heap, so it can be safely removed.
// When the whole list is processed, the number on top of the heap is kth largest

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);

            if (heap.size() == k + 1) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}