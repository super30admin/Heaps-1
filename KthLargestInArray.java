// Time Complexity : O(N Log K)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    Add all the elements to a Min Heap - PriorityQueue of size K.
    Once we have K elements in the queue, pop an element for every addition.
    Thereby, leaving the Kth largest element on top of the PriorityQueue.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (int num : nums){
            pq.add(num);
            i++;
            if (i>k) pq.poll();
        }
        
        return pq.peek();
    }
}