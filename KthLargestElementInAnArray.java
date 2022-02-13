//  Time Complexity: O(n*log(k))
//  Space Complexity: O(k)

import java.util.*;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}
