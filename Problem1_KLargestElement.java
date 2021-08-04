
// Time Complexity : o(nlogk)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums.length==0||nums==null)
            return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(a-b));
        
        for(int i:nums)
        {
             pq.add(i);
            
            if(pq.size()>k)
              pq.poll();
        }
           return pq.peek();
    }
}