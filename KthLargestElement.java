//Time Complexity - O(nlogk)
//Space Complexity - O(k)


class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int num : nums) {
        //add the element in the queue
        pq.add(num);
        if(pq.size() > k) {
          pq.poll();
        }
      }
      //return top most element
      return pq.poll();
    }
}