class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through all elements in the array
        for (int num : nums) {
            // Add the current number to the heap
            minHeap.add(num);
            
            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
