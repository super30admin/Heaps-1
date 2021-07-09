import java.util.PriorityQueue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(k)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
