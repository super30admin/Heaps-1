//Time Complexity : O(n logk), n -> Number of elements in the array, k -> Given k
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.PriorityQueue;

public class KthLargestInArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		KthLargestInArray obj = new KthLargestInArray();
		int[] nums = { 1, 5, 23, 7, 2, 6 };
		int k = 3;

		System.out.println(k + "th largest in the given array: " + obj.findKthLargest(nums, k));
	}

}
