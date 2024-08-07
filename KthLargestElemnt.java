import java.util.PriorityQueue;

public class KthLargestElemnt {
      public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);// min heap PriorityQueue<>((a,b) -> a-b); //for max heap - >
        int result = Integer.MAX_VALUE;                                                  // b-a
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > nums.length-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
