import java.util.*;

class Solution {
    // Using max heap
    // Time complexity is O(nlog(n-k))
    // Space complexity is O(n-k)
    // This solution is submitted on leetcode with no errors
    public int findKthLargest(int[] nums, int k) {
        // Edge case
        if(nums == null || nums.length == 0) return -1;
        Integer result = Integer.MAX_VALUE;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i <n; i++){
            pq.add(nums[i]);
            if(pq.size()>(n-k)){
                result = Math.min(pq.poll(),result);
            }
        }
        return result;
    }
}