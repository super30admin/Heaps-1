// Let n = length of nums array
// Time Complexity : total elements * TC of insertion/deletion into heap: nO(Log(k)) if using min-heap approach, nLog(n-k) if using max-heap approach
// Space Complexity : elements in tree: O(k) if using min-heap approach, O(n-k) if using max-heap approach
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.PriorityQueue;

public class FindkthLargestInArray {

    public int findKthLargestMaxHeap(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        //using max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int result = Integer.MAX_VALUE;

        for(int num: nums){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min(result, pq.poll());
            }
        }

        return result;
    }


    public int findKthLargestMinHeap(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        //using min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }

}
