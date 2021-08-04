// Time Complexity : O(N log K)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/**
 * Implementing using Min Heap
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int num: nums){
            pqueue.add(num);
            if(pqueue.size() > k)
                pqueue.poll();
        }
        
        return pqueue.peek();
    }
}