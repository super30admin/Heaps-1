//Time complexity is O(klogn)
//Space complexity is O(n)
//This solution is submitted on leetcode

public class BigN83KthLargesElemeentMaxHeap {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			for (int i = 0; i < nums.length; i++) {
				pq.add(nums[i]);
			}
			for (int i = 0; i < k - 1; i++) {
				pq.poll();
			}
			return pq.poll();
		}
	}
}