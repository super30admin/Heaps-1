// https://leetcode.com/problems/kth-largest-element-in-an-array/
// Time Complexity : O(n log k) where n is the number of elements in the input array and k is number of elements in the heap;
// Space Complexity : O(k) where k is number of elements in the heap;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach : Use a min-heap of size k to keep track of the k largest elements.
 *            The root of the min-heap will be the kth largest element.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}