import java.util.PriorityQueue;

/**
 * * Leetcode problem: 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 * 
 * Uses Min Heap to find the kth largest element.
 */
public class KthLargestElement1 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int k1 = k;
        while (k1 < nums.length) {
            if (nums[k1] > pq.peek()) {
                pq.poll();
                pq.add(nums[k1]);
            }
            k1++;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestElement1 kthLargestElement = new KthLargestElement1();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Kth Largest " + kthLargestElement.findKthLargest(nums, k));

        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        System.out.println("Kth Largest " + kthLargestElement.findKthLargest(nums2, k2));
    }

}
