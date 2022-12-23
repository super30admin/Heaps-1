// Time Complexity : O(n*log(n-k))
// Space Complexity : O(n-k+1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

// Your code here along with comments explaining your approach in three sentences only
//I have used max heap of size n-k+1 elements and returning the largest element in the heap;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return -1;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > (n - k + 1)) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}