// Time Complexity : O(N log k)
// Space Complexity : O(N - k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.PriorityQueue;

class findKthLarge {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        
        //max heap solution
        //custom comparator changes from ascending to descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        int result = Integer.MAX_VALUE;
        
        for(int num: nums){
            
            pq.add(num);
            
            if(pq.size() > nums.length - k){
                result = Math.min(pq.poll(), result);
            }
        }
        
        return result;
    }
    
    
}