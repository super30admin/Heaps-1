/**
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 * Leetcode: Yes
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //base
        if(nums.length == 0 || nums == null){
            return 0;
        }

        //logic
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0; i<n; i++){
            int num = nums[i];
            pq.add(num);

            if(pq.size() > n - k){
                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}