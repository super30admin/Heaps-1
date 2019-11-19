package demo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    
    public int findKthLargest(int[] nums, int k) {
		
////	brute force- sort the array and return kth index from end - time 0(N *logN)
//        Arrays.sort(nums);
//       return nums[nums.length - k];
    	
    	PriorityQueue<Integer> q = new PriorityQueue<>();   
    	//since integer - no need to override comparator
    	
    	for(int i=0; i < nums.length; i++) {
    		q.add(nums[i]);
    		
    		if(q.size() > k) {
    			q.poll();
    		}
    	}
    	
    	
    	return q.peek();
    }

}
