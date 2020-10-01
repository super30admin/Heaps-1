// TC: O(N) since we are traversing the array
// SC: O(k) since we are storing only k elements in the priority queue every time.

// Keep adding the values onto minheap until the size is k, if sizez is greater than k, remove the minimum element, this way, we are storing only k elements
// which are minimum to maximum, so this will return kth largest element once come out of for loop and return the first element

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargest {

	public int findkLargest(int[] nums, int k) {
		
//		Arrays.parallelSort(nums);
//		return nums[nums.length-k];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int n: nums) {
			
			pq.add(n);
			if(pq.size() > k) {
				pq.remove();
			}
		}
		return pq.remove();
	}
	
	public static void main(String[] args) {
		
		kthLargest kl = new kthLargest();
		int[] nums = {3,2,1,5,6,4};
		System.out.println(kl.findkLargest(nums, 2));
	}
}
