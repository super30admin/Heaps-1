class Solution {
    //maitain the size of heap n-k using max heap
    //TC: O(n log (n-k))
    //SC: 0(n-k)
    public int findKthLargest(int[] nums, int k) {
      int n = nums.length;
      int result  = Integer.MAX_VALUE;
       PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b-a); //maximum heap
       for(int num : nums){
           pq.add(num);
           if(pq.size() >n-k){
               result = Math.min(result, pq.poll());
           }
       }
       return result;
    }
}