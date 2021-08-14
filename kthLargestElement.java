// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num: nums) {
            pqueue.add(num);
            if(pqueue.size() > k)
                pqueue.poll();
        }
        return pqueue.peek();
    }
}