// Approach: Maintain a Min heap of k elements. As soon as size > k, poll()
// Time: O(n*logk)
// Space: O(k)

import java.util.*;

class Kth_largest_ele_in_array {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int n : nums) {
            heap.add(n);

            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}