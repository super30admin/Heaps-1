//Problem1  Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

// Time - O(N log k) Space - O(k) for heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length * k == 0){
            return 0;
        }
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}