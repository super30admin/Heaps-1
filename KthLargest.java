// Time Complexity : O(N log K)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. It can be done using min heap as well as max heap
 * 2. priorityqueue default is min heap. to construct max heap use lamda (a,b)->b-a.
 * 3. if it is min heap pop element if queue size is k and return top element.
 * 4. if it ia max heap pop element if queue size is n-k and return top element.
 */

import java.util.PriorityQueue;

public class KthLargest {
	//minheap
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int num : nums) {
			pq.add(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.poll();

	}
	
	//maxheap
	 public int findKthLargest1(int[] nums, int k) {
	        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
	        int result=Integer.MAX_VALUE;
	        
	        for(int num:nums){
	            pq.add(num);
	            if(pq.size()>(nums.length-k)){
	                result= Math.min(result,pq.poll());
	            }
	        }
	        return result;
	        
	    }
}
