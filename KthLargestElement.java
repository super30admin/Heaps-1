// Time Complexity : O(n), where n=nums.length
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use PriorityQueue which is a java implementation of min heap, and generally a min heap is used to get the max element.
// We create a heap of size k, so that at the end we have the required answer at the root.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}