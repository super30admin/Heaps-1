// TC: O(n log(k))
// SC: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return !pq.isEmpty() ? pq.peek() : -1;
    }
}