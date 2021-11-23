class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // Create a min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num :nums){
            // add () will do the heapify implictly
            pq.add(num);
            
            // Min heap must be of size k elements
            if(pq.size() > k){
                //remove the element as this will never be the k largest element since it is the                   min among all the elements in the heap. 
                pq.poll();
            }
        }
        
        // the root will be the Min element among the largest k elements indicating the kth                  largest element
        return pq.peek();
        
        
    }
}