// Time Complexity :O(n log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=0; i<nums.length; i++){
           pq.add(nums[i]);
           if(pq.size()>k){
               pq.poll();
           }
       }
       return pq.peek();
    }
}
