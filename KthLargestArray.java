// Time Complexity : O(n+klogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach : maintain a min heap. add elements to heap, as heap size >k, remove elements. At the end, kth largest element is at the top of heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //need kth largest so make a min heap
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()==k+1){
                pq.poll();
            }
        }
        return pq.poll();
    }
}