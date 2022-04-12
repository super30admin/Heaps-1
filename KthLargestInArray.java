import java.util.Arrays;
import java.util.PriorityQueue;

//Time Complexity : O(n log k)
//Space Complexity : O(k)
public class KthLargestInArray {	
	/**Approach2: Using Min Heap**/
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int num: nums) {
        	pq.add(num);
        	if(pq.size() > k) {
        		pq.poll();
        	}
        }        
        return pq.poll();
    }	
	
	// Driver code to test above 
	public static void main (String[] args) {
		KthLargestInArray ob = new KthLargestInArray();
		int[] nums= {3,2,3,1,2,4,5,5,6};
		int k=4;
		System.out.println(k+"th largest element is: "+ob.findKthLargest(nums, k));
	}
}
