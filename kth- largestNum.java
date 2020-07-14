// Time Complexity : O(nlogk) n- length of array, logk-heapify
// Space Complexity : O(k) --> O(1) because k is constant
// Did this code successfully run on Leetcode : Yes
//https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using Min Heap to find Max Elements
		// By default PriorityQueue uses min heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}

// Using Max heap by customizing priority Queue 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using Max Heap to find Max Elements
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>nums.length-k)
            {
                min=Math.min(min,pq.poll());
                
            }
                
        }
        return min;
    }
}