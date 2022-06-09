//https://leetcode.com/problems/kth-largest-element-in-an-array/
// Time Complexity :O(n logk)  
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    public int findKthLargest(int[] nums, int k) {
        //largest element use min heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();  //the elements on the top are minimum elements and they get poped out 
            //max elements stay in the priority queue of size k
        }
        return pq.peek();
    }
}