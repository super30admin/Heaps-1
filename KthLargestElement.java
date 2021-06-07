// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//TimeComplexity - O(log(k)) for heapify operations inside the Min-Heap queue, where k is the size of the priority queue at any given point
//SpaceComplexity - O(k) since there will be maximum of k elements stored in the priority queue at each iteration
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}