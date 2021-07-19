// Time Complexity : O(n log n - k)
// Space Complexity : O(n - k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);
            if(pq.size() > (nums.length - k)){
                int cur = pq.poll();
                result = Math.min(result, cur);
            }
        }
        return result;
    }
}