//TC: O(n logk)
//SC: O(k)
//approach: minheap of k size to store k largest elements

import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }
}
