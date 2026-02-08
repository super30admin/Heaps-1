class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap Solution
        // TC - O(n) : Iterate over all the items
        // SC - O(n) : Actually need only k for the queue.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();

        // Max Heap Solution
        // TC - O(n) : Iterate over all the items
        // SC - O(n) : Actually need only n-k for the queue.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > (n - k)) {
                res = Math.min(res, pq.poll());
            }
        }
        return res;

        // Max Heap Solution adding all the elements in the PQ
        // TC - O(n) : Iterate over all the items
        // SC - O(n) : Queue size
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        int res = 0;
        while (k != 0) {
            res = pq.poll();
            k -= 1;

        }
        return res;

    }
}