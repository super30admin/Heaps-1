// Time Complexity : O(nlog(k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package heap1;

import java.util.*;

public class KthLargestMinHeap {

    public int findKthLargest(int[] nums, int k) {
        //pq is ascending by default, for desc we can write (a,b) -> b -a
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
