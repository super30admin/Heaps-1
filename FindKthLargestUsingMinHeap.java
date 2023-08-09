package org.example;

import java.util.PriorityQueue;

// Time Complexity : O(n(log k))
// Space Complexity : O(k) ->space of queue
// Did this code successfully run on Leetcode : Yes
public class FindKthLargestUsingMinHeap {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++)  //O(n)
        {
            pQueue.add(nums[i]);  // O(log k)
            if(pQueue.size() > k)  //O(1)
            {
                pQueue.poll();  //O(log k)
            }
        }
        return pQueue.peek(); //O(1)
    }
}
