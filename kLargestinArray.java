
// Time Complexity : O(NlogK)
// Space Complexity : O(K) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            if(pq.isEmpty() || pq.size() < k || num > pq.peek()) pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
