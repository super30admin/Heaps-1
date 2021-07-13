package Heaps1;

public class KLargestElement {
	    // Time - O(n log k)
	    // Space - O(k)
	    public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int num:nums){
	            pq.add(num);
	            if(pq.size()>k){
	                pq.poll();
	            }
	        }
	        return pq.peek();
	    }
	}

