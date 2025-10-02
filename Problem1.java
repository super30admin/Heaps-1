// Time Complexity : O(nlogk) where n-number of elements and k is the size of priority queue
// Space Complexity : O(K) - K is size of priority queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using min heap we add elements to the priority queue, by default the elements are sorted in ascending order
// we maintain a heap of size k and when size > k then we pop the element which will always be the smallest among the all in the queue
// Return the element at the top of the priority queue which will be the kth largest
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        //return the element at the top of PQ
        return pq.peek();
        
    }
}
