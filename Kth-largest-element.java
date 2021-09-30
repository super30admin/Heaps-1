//Time complexity: O(N Log (N-K))
//Space complexity: O(N-K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        //max heap maintaining n-k elements
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > nums.length - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}