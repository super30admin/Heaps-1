import java.util.PriorityQueue;

public class KLargest {
    // TC O(NLogK)
    // SC O(K)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > nums.length - k + 1) {
                pq.poll();

            }
        }
        return pq.peek();
    }
}
