package org.example;
// Time Complexity : O(n(log k))
// Space Complexity : O(n-k) ->space of queue
// Did this code successfully run on Leetcode : Yes
import java.util.PriorityQueue;

public class FindKthLargestUsingMaxHeap {
    public int findKthLargest(int[] nums, int k) {

        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b)->b-a);

        for(int i=0; i<nums.length; i++) //O(n)
        {
            pQueue.add(nums[i]); //O(log k)
            if(pQueue.size()> nums.length-k)
            {
                result = Math.min(result, pQueue.poll());  //O(log k)
            }
        }
        return result;
    }
}
