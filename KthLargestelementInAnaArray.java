// Time Complexity : O(nlog(n-k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class KthLargestelementInAnaArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
