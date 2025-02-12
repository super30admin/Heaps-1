class FindKthLargestSolution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {// limit size to k , example: nums = [3,2,1,5,6,4], k = 2
                pq.poll();// remove every element except k elements where we have the answer
            }
        }
        return pq.peek();// since it's in Min Heap and size of Min heap is 2 , answer is the root of Min heap
    }
}