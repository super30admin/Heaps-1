/*
Time Complexity : O(nlogk): We loop over n elements and performs extractions of log*k complexity.
 Space Complexity : O(k): heap size
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : no
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
        
    }
}
