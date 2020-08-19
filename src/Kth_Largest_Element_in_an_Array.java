/***************************************Using Min Heap**************************************/
// Time Complexity :O(n log k), n is no of elements in array and for heapify it takes log k time
// Space Complexity : O(k), heap size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**Add all elements into a min heap to preserve ascending order
 * If the size of the heap is greater than k, then pop minimum. 
 * In the end the heap will have k elements and in the next pop should give the kth largest element**/

import java.util.PriorityQueue;
public class Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0)    
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();  // default min heap
		for(int i=0; i<nums.length; i++){
			pq.add(nums[i]);    // add to the heap

			if(pq.size() > k)   // if the size exceeds k we pop, and heapfiy happens and min element comes at top and then we remove it
				pq.poll();
		}
		return pq.poll();   // at the end we have kth largest element remaining (as k-1 elements smaller are removed)
	}
}

/***************************************Using Max Heap**************************************/
//Time Complexity : O(n log(n-k)) n is no of elements in array and heapify takes log n-k time
//Space Complexity : O(n-k), heap size
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Solution {
	public int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0)    
			return 0;
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // max heap
		for(int i=0; i<nums.length; i++){
			pq.add(nums[i]);    // add to the heap

			if(pq.size() > nums.length - k)   
				min = Math.min(min, pq.poll());	
		}
		return min;
	}
}