// Approach - 1 Min heap based solution
// Executed
class Solution {
    // T.C : O(nlogk)
    // S.C : O(n)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // min heap based solution
        for (int num : nums) {
            pq.add(num);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// Approach -2 Max heap based solution
// Executed
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // T.C : O(nlog(n-k))
        // S.C : O(n-k)
        if (nums == null || nums.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int result = Integer.MAX_VALUE;
        // max heap
        for (int num : nums) {
            pq.add(num);
            while (pq.size() > nums.length-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}