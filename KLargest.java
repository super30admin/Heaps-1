// This solution uses min heap to store at most k elements and add all the elements. Every iteration we can check if the elements cross k count and remove the minimum
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i:nums) {
            pq.add(i);
            if(pq.size()==k+1) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
