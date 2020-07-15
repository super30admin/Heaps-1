//Time complexity=O(N log k)
//Space complexity=O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

//We are creating a proirity queue, which is a min heap as we have to find the largest element in the array, and min heap stores the largest at the bottom of the queue. 
//So we are maintaining the size of min heap to be k, so if the length of queue is more than k than we are popping out the 1st element, and as per the min-heap property it will have mininimum element of the queue at the top

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
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