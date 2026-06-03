// Time Complexity : O(NlogK)
// Space Complexity : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}