// Problem 215. Kth Largest Element in an Array
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //min heap
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){ // O(n)
            pq.add(nums[i]); // O(log n) due to heap insertion
            if(pq.size() > nums.length - k){ // Check if the size exceeds the needed elements
                result = Math.min(result, pq.poll()); // O(log k) for heap removal
            }
        }
        return result;
    }
}
