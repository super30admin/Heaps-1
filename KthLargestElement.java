import java.util.PriorityQueue;
//Time Complexity : O(NLogK)
//Space Complexity :O(K) 
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :

public class KthLargestElement {
	 public int findKthLargest(int[] nums, int k) {
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i:nums){
	            if(k!=0){
	                pq.add(i);
	                k--;
	            }
	            else{
	               pq.add(i);
	               pq.poll(); 
	            }
	        }
	        
	        return pq.peek();
	    }
}
