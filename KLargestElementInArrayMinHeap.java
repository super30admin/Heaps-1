// TC: O(nlogk)
// SC: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}