import java.util.PriorityQueue;

/**
 * Time Complexity: O(nlogk) where n = size of array , k = size of priority queue
 * Space Complexity: O(k)
 */

public class KthLargestElement{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}