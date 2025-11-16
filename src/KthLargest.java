import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author Aditya sinha
 * Accpeted and submitted in leetcode using min heap
 */
public class KthLargest {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//min heap
        for(int num : nums) { // O(n)
            pq.add(num); // log(k)
            if(pq.size() > k) {
                pq.poll(); // log(k)
            }
        }
        return pq.peek();
    }
}
