// Time Complexity : O(NlogK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(pq.size()>k){
                pq.poll();
            }
                pq.add(nums[i]);   
        }
        while(pq.size()>k){
        pq.poll();
        }
        
        return pq.poll();
    }
}