/*
Time Complexity : O(NlogK)
Space Complexity : O(K)
Idea : Maintain a heap size of k and n-k largest element will be the root of that Priority Queue.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}