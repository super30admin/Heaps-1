// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums) {
            
            pq.add(num);
            
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}