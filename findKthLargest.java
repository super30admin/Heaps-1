// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

// Time Complexity: O(n * log k)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

import java.util.PriorityQueue;

public class findKthLargest {
    public static int getFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(getFindKthLargest(nums, k));
    }
}
