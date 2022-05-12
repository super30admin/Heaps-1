import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
