// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we use a max heap of size n-k so that we poll the elements which are greater than the kth largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size() > nums.length-k)
            {
               result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}