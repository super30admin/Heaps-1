// Time: O(nlogk)
// Space: O(k)
// Ran succesfully on Leetcode: yes
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // maintain a min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // return the peek() element
        return pq.poll();
    }
}