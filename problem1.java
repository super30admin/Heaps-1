// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/

// Time Complexity : O(n logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length;i++){
            pq.add(nums[i]); 
            if(pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}