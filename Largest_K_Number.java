// Time Complexity : O(nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        
        for(int i = 0;i<k;i++){
            minHeap.add(nums[i]);
        }
        
        for(int i = k; i < nums.length; i++){
            if(nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}