// Time Complexity : O(nlogk) where n is the length of nums, logk for insertion into pq
// Space Complexity : O(k) Pq size at every time
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new  PriorityQueue<>((a,b) -> (a-b));
        for(int i=0; i<nums.length; i++)
        {
            pq.offer(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
         
        return pq.poll();
    }
}