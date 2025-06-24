// Time complexity O(n log(k) )
// Space complexity O(k)
// Runs on LeetCode Yes
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i=0; i< nums.length; i++){
            q.add(nums[i]);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.poll();
    }
}