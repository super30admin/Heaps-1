class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > (nums.length-k + 1) ) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
