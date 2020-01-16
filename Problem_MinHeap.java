/**
LeetCode Submitted : YES
Space Complexity : O(Nums.length)
Time Complexity : O(Nlog(N))
The idea is to use min/max heap to store the elements and then perform heapify function to get top k elements. 
**/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : nums)
            pq.add(i);
        
        int count = 0;
        int results = -1;
        while (pq.size() != k){
            pq.poll();
        }
        return pq.poll();
    }
}
