class KthLargest {
    // TC: O(n log k) SC:O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > nums.length - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}