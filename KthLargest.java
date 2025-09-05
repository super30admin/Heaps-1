class KthLargest {
    //Idea is to use Min Priority queue of size.
    //While iterating over the array, n-k small elements will be removed leaving k large elements behind
    //TimeComplexity: O(nlogk)
    //SpaceComplexity: O(k) 
    public int findKthLargest(int[] nums, int k) {
     PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
     for(int i:nums){
         minheap.add(i);
         if(minheap.size()>k){
             minheap.remove();
         }
     }
        return minheap.remove();
    }
}