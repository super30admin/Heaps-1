// Time Complexity : O (NlogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.*;
public class KthLargestElement {

	private int findKthLargest(int[] nums, int k) {
		
		if(nums == null || nums.length ==0) {
			return 0;
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0; i<k; i++) {
			minHeap.add(nums[i]);
		}
		
		for(int i=k; i<nums.length; i++) {
		
			if(nums[i] > minHeap.peek() ) {
				minHeap.remove();
				minHeap.add(nums[i]);
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		KthLargestElement f = new KthLargestElement();
		int result = f.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4);
		System.out.println(result);

	}

}
