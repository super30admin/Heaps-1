class Solution {
    int result;
    public int findKthLargest(int[] nums, int k) {
        result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
            // pop the top element of the heap when the size of the heap is greater than k 
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
