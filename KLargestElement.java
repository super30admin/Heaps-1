// TC: n(log k) where n is size of list & k is the kth largest element required
// SC: k 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums){
			// add the num from list
            pq.add(num);         
            // after adding heapify happens and the smallest element comes to the top
			
			// remove the smallest element if the q size > k
			// which means if k is 2 then the topmost element will be smallest among 3 elements
            if(pq.size() > k)
                 pq.poll();
            
        }
        
		// in the end the last k elements will be present in queue in increasing order
		// the top element will be the kth largest
        return pq.poll();
        
    }
}