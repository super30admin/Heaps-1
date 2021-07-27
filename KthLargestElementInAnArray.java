// Time Complexity: O(Nlogk)
// Space Complexity: O(k)
// Run on Leetcode: Yes
// Issues faced: None

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: nums){
            pq.add(a);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
