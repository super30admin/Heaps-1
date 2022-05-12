/*
Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
TC: O(nlog k)
SC: O(k)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(nums[i]);
            if (i >= k) {
                pq.poll();
            }
        }
        
        return pq.poll();
    }
}