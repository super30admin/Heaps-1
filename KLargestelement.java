// Time Complexity :  O(Nlogk) integers 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) ->  y - x);
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        int i = 1;
        while(i < k){
            i++;
            pq.poll();
        }
        return pq.poll();
    }
}