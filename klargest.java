// Time Complexity : o(nlogn)
// Space Complexity : o(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // this takes care of the min heap aspect
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
            if(pq.size() > k){ // k because we are restricting the size to k
                pq.poll(); // remove the root element
            }
        }

        return pq.peek(); // return the root element
    }
}