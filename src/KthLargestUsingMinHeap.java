import java.util.PriorityQueue;

public class KthLargestUsingMinHeap {
	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int num : nums) {
			pq.add(num);

			if (pq.size() > k) {
				pq.poll();
			}

		}

		return pq.peek();

	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		KthLargestUsingMinHeap minheap = new KthLargestUsingMinHeap();

		System.out.println(minheap.findKthLargest(nums, 2));
	}
}
