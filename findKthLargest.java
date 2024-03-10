package week7.day1;

import java.util.PriorityQueue;

//TC - O(n log k)
//SC - O(log k)
class Solution {
  public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for (int i : nums) {
          pq.add(i);
          if (pq.size() > k) {
              pq.poll();
          }
      }
      return pq.peek();
  }
}

/**
MAX Heap
public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
      int result = Integer.MAX_VALUE;
      for (int i : nums) {
          pq.add(i);
          if (pq.size() > nums.length-k) {
              result = Math.min(result,pq.poll());
          }
      }
      return result;
  } */

  /**
  Way -3
  Max heap
  public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
      for (int i : nums) {
          pq.add(i);
          if (pq.size() > nums.length-k+1) {
              pq.poll();
          }
      }
      return pq.peek();
  } */
public class findKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
