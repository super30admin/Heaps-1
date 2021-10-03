package Heaps1;
// Time Complexity : O(nlogn)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes

import java.util.PriorityQueue;

public class kthLargestInArray {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public int findKthLargest(int[] nums, int k) {
            for(int num:nums){
                pq.add(num);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
}
