package S30.Heaps_1;

import java.util.PriorityQueue;

/*
Time Complexity : O(NlogK)
Space Complexity : O(K)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class KthLargestTerm {

    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0) return -1;

        //constructing a min heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (x,y) -> x - y
        );

        for(int i = 0; i < k; i++){
            heap.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(heap.peek() < nums[i]){
                heap.offer(nums[i]);
            }
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
