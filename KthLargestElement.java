// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, create a priority queue of size k. Add elements of array and when size is greater than k, remove the top element. Finally
 * return peek.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}