// Time complexity: O(n log k)
// Space complexity: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //intitialize priority queue for implmenting min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // iterate through the array and keep adding elements in priority queue
        // keep popping the top most element from the queue when the size of queue
        // becomes greater than k
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }
        // the top most element of the queue will be the Kth largest element
        return pq.poll();
    }
}