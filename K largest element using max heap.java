// Time complexity - 0(Klogn)
// space complexity - 0(n)
// Code successfully executed on leetcode

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            result =pq.poll();
        }
        return result;
    }
}