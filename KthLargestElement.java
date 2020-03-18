/*
Time: O(N log K) 
Space: O(K)

Algorithm:
=========
1. Use k-sized minHeap to update min continuously so that only top k elements exist in the heap
2. Return peek
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // insert into minHeap
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        // compare n-k elements with elements in heap
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}