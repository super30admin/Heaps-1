// Problem 1 : Kth Largest Element in an Array
// Time Complexity : O(n*log k) where n is the number of elements in the nums and k is the number of the elements in the heap
// Space Complexity : O(k) where k is the number of the elements in the heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
None
*/

// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // initializing the priority queue ie. mini heap for stroing the k elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // length of the nums array
        int numsLength = nums.length;
        // iterate through nums array
        for (int i = 0; i < numsLength; i++) {
            // added the nums[i] element to priroity queue
            pq.add(nums[i]);
            // if the size of the priority queue is greater than k then pop the smallest element
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Return the top element of the priority queue which is kth largest element of the array
        return pq.peek();
    }
}