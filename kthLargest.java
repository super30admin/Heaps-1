// Time Complexity : O(nlogk), where n is the total number of nodes and k is the size of the heap.
// Space Complexity : O(k), where k is the size of the heap.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. Create a minHeap and add all the elements to the heap.
2. If the size of the heap is greater than k, poll the top element.
3. Return the top element after all the elements are added to the heap.
 */

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            if(minHeap.size() == k && minHeap.peek() >= num)
                continue;
            minHeap.offer(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.poll();
    }
}