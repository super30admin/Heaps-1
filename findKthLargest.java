// Time Complexity : O(N log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.PriorityQueue;

class findkthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums){
            
            pq.add(num);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}