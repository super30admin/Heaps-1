// Time Complexity : O(n log (n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > n - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
