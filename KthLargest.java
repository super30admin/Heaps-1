// Time Complexity : O(NlogK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        // Add all elements in PQ -> Make sure we only maintain the PQ of size k
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) pq.poll();
        }

        return pq.poll();
    }
}