// Time Complexity : O(n log k) n is length of nums
// Space Complexity : O(k) as the heap is k sized
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: while building the minheap, check size and poll smallest elements
// can also be done using maxheap where we poll every time heap becomes larger than nums length - k. 

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
