import java.util.PriorityQueue;
import java.util.Queue;

// TC - O(N logk)
// SC - O(k)

public class KthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> minHeap = new PriorityQueue<>();
            for (int num : nums) {
                minHeap.add(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            return minHeap.peek();
        }
    }
}