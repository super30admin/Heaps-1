
// Time Complexity : O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        for (int num: value){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}