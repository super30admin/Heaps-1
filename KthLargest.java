// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        // for(int i=0; i<nums.length; i++) {
        //     pq.add(nums[i]);
        //     if(pq.size() > k){
        //         pq.poll();
        //     }
        // }
        int result = Integer.MAX_VALUE;
        for(int i=0; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > n-k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
        
    }
}