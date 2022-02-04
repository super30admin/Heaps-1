package heaps1;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	//Time Complexity : O(n log k), where n is the size of nums and k is the size of minHeap
	//Space Complexity : O(k), where k is the size of minHeap - PriorityQueue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i: nums) {
            minHeap.offer(i);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        return minHeap.poll();
    }
	
	//Time Complexity : O(n log (n-k)), where n is the size of nums
	//Space Complexity : O(n-k), where n-k is the size of maxHeap - PriorityQueue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int res = Integer.MAX_VALUE;
        for(int i: nums) {
            maxHeap.offer(i);
            if(maxHeap.size() > nums.length - k)
                res = Math.min(res, maxHeap.poll());
        }
        
        return res;
    }
}
