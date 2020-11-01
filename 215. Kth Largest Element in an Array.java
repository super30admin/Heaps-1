class Solution {// time of N log k  and space of O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}