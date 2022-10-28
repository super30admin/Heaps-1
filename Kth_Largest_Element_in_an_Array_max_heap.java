// TC : O(nlogn-k)
// SC : O(k)
// MAX HEAP Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > nums.length - k)
                result = Math.min(result, pq.poll());
        }
        
        return result;
    }
}
