// Time Complexity :nLogk
// Space Complexity :k
// Did this code successfully run on Leetcode :yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int n = nums.length;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            pq.add(nums[i]);
        }
        for (int i = n - k; i < nums.length; i++) {
            pq.add(nums[i]);
            max = Math.min(pq.poll(), max);
        }
        return max;

    }
}