// S30 Big N Problem #83 {Medium}
// 215. Kth Largest Element in an Array
// Time Complexity :O(n log k)
// Space Complexity :O(k) space in min heap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// Creating Min Heap, checking size and polling lowest elements untill k large elements remain
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> pq=new PriorityQueue<>((a,b)->a-b);
        
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}