// Kth Largest Element in an Array
// Time Complexity : O(n logK)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// will apply min heap. iterate over the nums array and add that num to the PriorityQueue.
// when the PriorityQueue size is grater than k, then remove the top element.
// in this way, at last will have 2nd largest & largest element in the PriorityQueue & return the top.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}