//Time Complexity : O(NLogK)
//Space Complexity :O(K) 
//Did this code successfully run on Leet code :YesYes
//Any problem you faced while coding this : No

import java.util.*;

class KthLargestElementArray{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums){
            pq.add(num);
            if (pq.size()> k) pq.poll();
        }
        return pq.peek();
    }
}