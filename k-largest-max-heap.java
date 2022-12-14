
//tc is O(nlog(n-k)) = O(n)
//sc is O(n-k) = O(1)
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int size = n - k;
        int min = Integer.MAX_VALUE;

        // Min Heap Based solution
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);

            if (pq.size() > size) {
                min = Math.min(pq.poll(), min); // this removes the root from heap
            }
        }

        return min;

    }
}