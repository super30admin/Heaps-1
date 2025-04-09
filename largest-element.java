// TC: O(n log k) 
// SC: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
        minHeap.add(num);
        // If the heap size exceeds k, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.remove();
        }
    }
    // The root of the heap is the kth largest element
    return minHeap.remove();
}