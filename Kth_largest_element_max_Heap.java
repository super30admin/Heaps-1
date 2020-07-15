
//Time Complexity : O(Nlog(N - K))
//Space Complexity: O(N-K)
import java.util.*;

class Solution1 {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			if (pq.size() > nums.length - k) {
				min = Math.min(min, pq.poll());
			}
		}
		return min;
	}
}