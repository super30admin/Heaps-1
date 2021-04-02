// Time Complexity : get operation -> O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
      //we will use a priority queue here that acts as a min heap
      PriorityQueue<Integer> heap = new PriorityQueue<>();
      for(int num:nums)
      {

        heap.add(num);
        //at this point the smallest in the heap gets removed
        if(heap.size()>k)
        {
          heap.remove();
        }
      }
      //the one at the top is going to be the kth smallest as the size of the heap will be k
       return heap.peek(); 
    }
}