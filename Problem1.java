/*
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

Time Complexity : O(nlogk)
Space Complexity : O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0){
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}