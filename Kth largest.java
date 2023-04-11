//Time Complexity:O(nlogk)
//Space Complexity:O(1)
// implemented Min Heap to find Kth largest element 

class Solution {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int findKthLargest(int[] nums, int k) {

        for(int num:nums){
          pq.add(num);
          if(pq.size()>k)
          pq.poll();
        }
        return pq.poll();
        
    }
}
