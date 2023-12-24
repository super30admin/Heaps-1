// Time Complexity : O(N logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.PriorityQueue;

public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

    for(int i : nums){
      if(heap.size() != k){
        heap.add(i);
      }
      else{
        int t = Math.max(heap.poll(),i);
        heap.add(t);
      }
    }

    return heap.poll();
  }
}
