// Time Complexity : O (nlogk)
// Space Complexity : O (k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Keep min-heap of size k. When inserting numbers , when size becomes greater than k , 
//then remove root element as it can never be kth largest as already there are k large in the heap. 

class KLargest {
    public int findKthLargest(int[] nums, int k) {
    
    PriorityQueue<Integer>pq= new PriorityQueue<>();
    
    for(int i=0;i<nums.length;i++)
    {
        pq.add(nums[i]);
        if(pq.size()>k)
        {
            pq.poll();
        }
    }
        return pq.peek();
        
    }
}