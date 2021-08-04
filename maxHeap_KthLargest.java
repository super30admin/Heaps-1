// Time Complexity : O(N log k)
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/**
 * Implementing using Max Heap
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        //max heap initialization
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a,b) -> (b-a));
        
        int result = Integer.MAX_VALUE;
        
        for(int num: nums){
            pqueue.add(num);
            if(pqueue.size() > nums.length - k)
                result = Math.min(pqueue.poll(), result);
        }
        
        return result;
    }
}