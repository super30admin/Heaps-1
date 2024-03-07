// Time Complexity : O((n * log(k)) [n: nums.length; k: kth largest element]
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return helperBruteForce(nums, k);
        return helperMinHeap(nums, k);
        // return helperMaxHeap(nums, k);
    }

    private int helperBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int helperMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    private int helperMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int result = Integer.MAX_VALUE;
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > nums.length - k) {
                result = Math.min(pq.poll(), result);
            }
        }
        return result;
    }
}