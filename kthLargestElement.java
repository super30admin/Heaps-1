// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes			
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        int l= 0;
        for(int i =0 ; i < nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}