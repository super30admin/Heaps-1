// Time Complexity :O(nlogK)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // add first k elements to the heap
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }

        }

        return minHeap.poll();
    }
}