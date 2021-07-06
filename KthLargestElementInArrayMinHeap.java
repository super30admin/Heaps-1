class Solution {
    public int findKthLargest(int[] nums, int k) {
        //pq is by deafult min healp
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}