// Time Complexity : O(n * logK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.PriorityQueue;

public class KLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b -a);
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            queue.add(num);
            if(queue.size() > nums.length - k){
                min = Math.min(min, queue.poll());
            }
        }
        return min;
    }
}