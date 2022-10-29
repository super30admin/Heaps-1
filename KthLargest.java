// Time Complexity : O(n log k) due to heapify
// Space Complexity : O(k) cause we are restricting the heap size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}