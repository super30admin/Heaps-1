// TC : O(nlogk)
// SC : O(k)
// MIN HEAP Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}
