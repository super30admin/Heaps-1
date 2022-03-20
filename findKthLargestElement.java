// Time Complexity : O(nLogK) - the TC of find and remove will be O(Log k) which will be run n times in an array.
// Space Complexity : O(k) - storing at a time k elements
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/663767169/)
// Any problem you faced while coding this : No
// My Notes : Create the min heap with size where the second largest element will be on the top.

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            pq.offer(nums[i]);
            // if size k + 1 then remove the min elem from top
            if(pq.size()>k){
                pq.poll();
            }
        }
        // return the top elem which is kth largest
        return pq.peek();
    }
    
    // Using BruteForce library functions
    // Time : nlogn + Constant retrival
    // Space : O(1)
    public int findKthLargestBF(int[] nums, int k) {
        // Sorting
        Arrays.sort(nums);
        // returning from last the kth element
        return nums[nums.length-k];
    }
}