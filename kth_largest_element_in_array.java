// Time Complexity :O(nlog(k)), where n is the number of elements in the array and k denotes the kth largest number to be found
// Space Complexity :O(k), k th largest element to be found (size of the priority queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner approach of your code in plain English
//1. Create priority implementing min-heap.
//2. Put all the elements 1 by 1 from the nums array to the priority queue, And once the capacity is reached (k), poll the top elements
//3. Once all the elements are traversed, top of the priority queue is the kth largest element
// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}