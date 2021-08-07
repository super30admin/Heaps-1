// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a,b)->(b-a));
        int result = Integer.MAX_VALUE;
        for(int x : nums) {
            pqueue.add(x);
            if(pqueue.size() > (nums.length-k)) 
                result = Math.min(result, pqueue.poll());    
        }
        return result;
    }
}