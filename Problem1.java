// Time Complexity : O(nlog(n-k)) where n is the length of the input, k is the input parameter
// Space Complexity : O(n - k) where n is the length of the input, k is the input parameter
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // using max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > nums.length - k) {
                temp = pq.poll();
                if (min > temp) {
                    min = temp;
                }

            }
        }
        return min;
    }
}