package week7.heaps;

import java.util.PriorityQueue;

/*
* TC: O(n*log(k))
* SC: O(k)
* */
public class KLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
