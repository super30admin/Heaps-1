// Time Complexity :O(klogn) - n=nums
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}