
//T.C :O(n logk)
//S.C : O(k)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

import java.util.PriorityQueue;

public class Problem1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
