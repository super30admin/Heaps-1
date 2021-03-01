class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k, Collections.reverseOrder());
        
        for(int num  : nums) {
            pq.add(num);
        }
        int poped = Integer.MIN_VALUE;
        while(k--> 0) {
             poped = pq.poll();
        }
        
        return poped;
    
    }
}
