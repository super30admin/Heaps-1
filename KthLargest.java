import java.util.PriorityQueue;

public class KthLargest {
    //min heap
    // Time Complexity : O(n*log(k)) where n is the length of the nums array
    // Space Complexity :O(k)
    // Did this code successfully run on Leetcode :yes
    public int findKthLargest(int[] nums, int k) {
        if(nums == null){
            return -999999;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //by default min heap
        for(int i =0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    //max heap:
    // Time Complexity : O(n*log(n-k)) where n is the length of the nums array
    // Space Complexity :O(n-k)
    // Did this code successfully run on Leetcode :yes
    public int findKthLargestMaxHeap(int[] nums, int k) {
        if(nums == null){
            return -999999;
        }

        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        int n = nums.length;
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
            if(pq.size() > n-k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
