// Time Complexity : O(n*logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }
}