/*
* Approach:
*  1. Create priority queue with minheap priority,
        this queue should hold max of k min elements at a time(min at top).
        iterate over elements and add elements into queue.
            if queue.size() > k, poll the first min value.
        return queue.peek() as kth largest
* 
*  2. Using max heap, 
        we have to maintain the heap size of n-k
            (which holds n-k smaller elements with max at top)
        if queue.size()>n-k, poll the elements and store the min in a variable.

        return the variable after iterating over all elements. 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nlogk)
    n - elements 
    k - heapify on k elements
* 
* Space Complexity: O(k)
    k - elements in heap
* 
*/

import java.util.PriorityQueue;

public class Kthlargest {
    // public int findKthLargest(int[] nums, int k) {
    //     // min heap
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();

    //     for(int index = 0; index<nums.length; index++){
    //         pq.add(nums[index]);

    //         if(pq.size() > k)
    //             pq.poll();
    //     }

    //     return pq.peek();
    // }

    public int findKthLargest(int[] nums, int k) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        int n = nums.length;

        int kthlargest = Integer.MAX_VALUE;

        for(int index = 0; index<nums.length; index++){
            pq.add(nums[index]);

            if(pq.size() > (n-k)){
                kthlargest = Integer.min(kthlargest, pq.poll());
            }
        }

        return kthlargest;
    }
}
