// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.PriorityQueue;

public class KthLargestEleInArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : nums){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.poll();
    }
}
