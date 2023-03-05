import java.util.PriorityQueue;
//Time Complexity : O(NlogK) 
//Space Complexity : O(K)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put all elements in Priority queue. When queue size is > k, pop the top
 * element. Iterate for all elements. At last, return the queue top element
 * which would be the kth largest element.
 *
 */
class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);
			while (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}