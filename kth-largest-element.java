// Time - O(KlgK)
// Space - O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length ==0) {
            return -1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++) {
            pq.add(nums[i]);
            
            if(pq.size() > k) {
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}
