class KthLargestElementInArray {
    
    // Time Complexity: O(nlogk)
    // Space Complexity: O(k)
    
    public int findKthLargest(int[] nums, int k) {
        // Edge Case Checking
        if(nums == null || nums.length == 0 || k <= 0)
            return 0;
        
        // Initialize a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            // Add an element to the heap
            minHeap.add(i);
            // If minHeap size > k, then remove the root element
            if(minHeap.size() > k)
                minHeap.remove();
        }
        // Since it is a minHeap of size k - the root element would be the k-th largest element
        return minHeap.remove();
    }
}