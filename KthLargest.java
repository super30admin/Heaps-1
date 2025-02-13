import java.util.PriorityQueue;

/**
 * Time Complexity: O(nlogk) - Inserting an element into a min-heap takes O(log k) time and n such elements
 * Space Complexity: O(k), elements in PQ at a given time
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * For finding the largest K, using min heap and keeping the size to k of that min heap,
 *  so that the root then provides kth largest number
 */

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        // Your code here
        KthLargest obj = new KthLargest();
        int result = obj.findKthLargest(new int[]{4,1,3,-1,7,5}, 4);
        System.out.println(result);
        assert (result == 3);
    }
}