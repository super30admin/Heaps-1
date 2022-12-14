import java.util.*;

//TC is O(nlogk) = O(n)
//SC is O(k) = O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        // Min Heap Based solution
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);

            if (pq.size() > k) {
                pq.poll(); // this removes the root from heap
            }
        }

        return pq.poll();

    }
}