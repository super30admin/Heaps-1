import java.util.PriorityQueue;
//Time Complexity: O(n log k) where n is the number of elements in the array and k is the size of the priority queue.
//Space Complexity: O(k) for the priority queue storing the k largest elements.
//LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/

/**
 * Finds the kth largest element in an unsorted array using a min-heap.
 * Maintains a priority queue of size k to track the k largest elements.
 * Time complexity is O(n log k) and space complexity is O(k).
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();

    }
}
