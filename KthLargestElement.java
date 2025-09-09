// Time Complexity : O(n log k), n -> no. of elements in array
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use min heap of size k
// 2. Add each element in heap, whenever size exceeds k, remove min
// 3. Min element at the end is the kth largest element

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums) {
            heap.add(num);
            if(heap.size() == k+1) {
                heap.remove();
            }
        }
        return heap.peek();
    }
}
