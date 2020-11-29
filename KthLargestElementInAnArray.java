// Time Complexity : O(N log(k))
// Space Complexity : O(log(k))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We will be using the minheap of size k. Once all the elements are processed, return top element of heap
 * */


import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap
        for(int n : nums){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}