// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); // O(logk)
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

// Time Complexity : O((n-k)logk)
// Space Complexity : O(k)

// Max Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); // O(logk)
            if (pq.size() > (n - k)) {
                result = Math.min(result, pq.poll());
            }
        }

        return result;
    }
}