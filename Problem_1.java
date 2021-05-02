//min heap
//Time Complexity: O(nlogk)
//space Complexity:k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}

//max heap
//Time Complexity: O(nlog(n-k))
//space Complexity:n-k
class Solution {
  public int findKthLargest(int[] nums, int k) {
      int n =nums.length;
      int min =9999999;
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
      for(int num:nums){
          pq.add(num);
          if(pq.size()>n-k) {
              min=Math.min(pq.poll(),min);
          }
      }
      return min;
  }
}