// Time Complexity : O(n log(k)) --> where n is number of elements in an input array and k is the size of heap
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode (215): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) { // O(n log(n-k))
            pq.add(nums[i]);
            if (pq.size() > nums.length - k) min = Math.min(min, pq.poll());
        }
        return min;
    }
}