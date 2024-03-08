import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //TC: O(nlog(n-k))
        //SC: O(k)
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);//max heap
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
            if(pq.size()>n-k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
