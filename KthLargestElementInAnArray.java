/*
 * KthLargestElementInAnArray
 *
 * Approach:
 * Use a min-heap (PriorityQueue) that keeps the k largest elements seen so far.
 * Iterate through the array and add each element to the heap. If the heap size
 * exceeds k, remove the smallest element. After processing all elements, the
 * root of the min-heap is the k-th largest element.
 *
 * Time complexity: O(n log k), where n = nums.length and k is the requested rank.
 * Space complexity: O(k) for the heap.
 *
 * LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.PriorityQueue;
import java.util.Objects;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and nums.length");
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            priorityQueue.add(n);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        Integer result = Objects.requireNonNull(priorityQueue.peek());
        return result;
    }

    public static void main(String[] args) {


        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
