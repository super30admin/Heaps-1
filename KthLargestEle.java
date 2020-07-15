/**
 * Time: O(nlogk) n- length of the input array nums and k - kth input value
 * Space:O(k) - store heap ele
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        for(int n:nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}