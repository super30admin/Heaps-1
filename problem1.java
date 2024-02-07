// Time Complexity :O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.PriorityQueue;

//   finds the kth largest element in the given array nums using a priority
//   queue with a size constraint of k
class problem1 {
    PriorityQueue<Integer> pq;
    public int findKthLargest(int[] nums, int k) {
        pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}