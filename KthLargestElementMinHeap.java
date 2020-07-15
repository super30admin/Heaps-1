// Time Complexity : O(nlogk). n is the total number of elements. k is the number of elements in heap
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer>pq = new PriorityQueue();
        
        for(int i=0;i<nums.length;i++){
            
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.remove();
    }
}
