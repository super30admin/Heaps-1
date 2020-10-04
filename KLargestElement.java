// Time Complexity : On(logk) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue();
        
        for(Integer num: nums){
            minheap.add(num);
            
            if(minheap.size()>k){
                minheap.remove();
            }
        }
        return minheap.remove();
    }
}