import java.util.PriorityQueue;

/*
 * Time Complexity of the algorithm is O(n log K) where n is no of elements in a array and k is size of heap
 * space Complexity will O( k) where k is size of heap
 */

public class KthLargestElementinanArray {

	// Max- Heap

	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int max = Integer.MAX_VALUE;

		for (int n : nums) {

			pq.add(n);

			if (pq.size() > nums.length - k) {
				max = Math.min(max, pq.poll());
			}

		}

		return max;

	}

	// Min- Heap

//     public int findKthLargest(int[] nums, int k) {

//         PriorityQueue<Integer> pq= new PriorityQueue();

//         for(int n: nums){

//             pq.add(n);

//             if(pq.size() > k){
//                 pq.poll();
//             }

//         }

//         return pq.peek();

//     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
