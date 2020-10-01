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
