import java.util.PriorityQueue;
// T.C - O(nlog(k))
// S.C - O(k)

// Create a min heap to store K elements, Kth largest would be at top of the heap.
public class KthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k)
                    pq.poll();
            }
            return pq.peek();
        }
    }
}
