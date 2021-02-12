///////////////////////////////////////////MAX HEAP///////////////////////////////////////////////////
// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //intialize a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        //have a min value
        int min = Integer.MAX_VALUE;
        //start iterating thorugh the nums array
        for(int n : nums){
            pq.add(n);
            //if the size of the pq becomes greater than n-k then pop the top.
            if(pq.size() > nums.length-k){
                int temp = pq.peek();
                pq.poll();
                //check if the element you popped is the minimum value. You will have k elemetns to check because they won't fit in the pq 
                //because they are the largest elements 
                min = Math.min(min,temp);
            }
        }
        //the top of the pq will have the kth largest element 
        return min;
    }
}