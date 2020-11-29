import java.util.PriorityQueue;

public class KthLargestUsingMaxHeap {
	public int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);// max heap implementation
		int result = 0;
		for (int num : nums) {
			pq.add(num);

			if (pq.size() > n - k) {
				result = pq.poll();
			}

		}

		return Math.min(result, pq.peek());

	}
}
