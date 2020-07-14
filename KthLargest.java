// Time Complexity : O(n log k)
// Space Complexity : O(k) Priority queue will hold k elements at any instant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Using a min heap or max heap decision
/* Your code here along with comments explaining your approach: Put first k values to the priority queue. We would be using a min heap in this.
The min element will be at the top. For each of the new incoming values, it will be compare to the top and if the value is greater than the top,
put it into the priority queue, remove the top element before this. Heapify occurs and again the min value comes at the top. But we are replacing
the top with the greater element always and hence at the end, we are remaining with kth largest element at the top of the queue.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){return 0;}                                 // Base Case
        int result=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);                // Min heap
        for(int i: nums){
            if(pq.size() < k){
                pq.add(i);                                                                  // Add till PQ size is lesser than k
            } else {
                if(i > pq.peek()){                                                  // Compare the incoming value with the top value
                    pq.poll();
                    pq.add(i);                                                  // Replace the greater value with the min element
                }
            }
        }
        return pq.peek();                                                               // Return the kth largest element from the queue
    }
}