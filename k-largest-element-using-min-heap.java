import java.util.*;

class Solution {
    // Using min heap
    // Time complexity is O(nlogk)
    // Space complexity is O(k)
    // This solution is submitted on leetcode with no errors
    public int findKthLargest(int[] nums, int k) {
        // Edge case
        if(nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}