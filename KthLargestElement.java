// Time Complexity : O(nlogk) n -> length of nums array
// Space Complexity : O(k) k elements in priority queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : For finding kth largest element, a min heap can be used. Once initial k elements are populated in the heap, based on comparisons with next elements, minimum element from heap can be popped out.
// At the end, kth largest element will be at the top of the heap.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // edge case
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        
        while(k < nums.length) {
            if(nums[k] > minHeap.peek()) {
                if(!minHeap.isEmpty())
                    minHeap.poll();
                minHeap.offer(nums[k]);
            }
            k++;
        }
        
        return minHeap.poll();
    }
}

