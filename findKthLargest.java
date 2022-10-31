class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums.length==0 || nums==null) return -1;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
            
            
        }
        
        return pq.poll();
        
    }
}

// Time Complexity : O(NKlogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no