/*
Time Complexity : findKthLargest_maxHeap() - O(k*logn)
				  findKthLargest_minHeap() - O(n*logk)
Space Complexity : findKthLargest_maxHeap() - O(n) - where n is the number of elements in nums
				   findKthLargest_minHeap() - O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
*/

class Solution {
    public int findKthLargest_maxHeap(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return 0;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int res = -1;
            
        for (int i = 0; i < nums.length; i++)
           pq.add(nums[i]);
        
    
        for (int i = 0; i < k; i++)
            res = pq.poll();
        
        return res;
    }
	
	 public int findKthLargest_minHeap(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
        {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (pq.size() < k)
            {
                pq.add(nums[i]);
            }
            else
            {
                if (pq.peek() < nums[i])
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        
        return pq.poll();
    }
}