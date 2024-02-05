class Solution {
    //maitain the size of heap k
    //TC: O(n log k)
    //SC: 0(1)
    public int findKthLargest(int[] nums, int k) {

       PriorityQueue <Integer> pq = new PriorityQueue<>(); //for default minheap
       //max heap PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b-a);
       for(int num : nums){
           pq.add(num);
           if(pq.size() > k){
               pq.poll();
           }
          
       }
       return pq.peek();
    }
}