import java.util.PriorityQueue;

/**
 * Leetcode problem: 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Time Complexity: O((n+k) log n)
 * Space Complexity: O(n)
 * 
 * Uses Max Heap to find the kth largest element.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pg = new PriorityQueue<>((a, b) -> b - a); // min heap
        for (int i = 0; i < nums.length; i++) {
            pg.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            System.out.println(pg.poll());

        }
        return pg.poll();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Kth Largest " + kthLargestElement.findKthLargest(nums, k));

        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        System.out.println("Kth Largest " + kthLargestElement.findKthLargest(nums2, k2));
    }
}