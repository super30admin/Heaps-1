// TC: O(nlogk)
// SC: O(k)

import java.util.PriorityQueue;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<n;i++){
            int num = nums[i];
            if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}
