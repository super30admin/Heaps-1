// Time Complexity : O(nlog(k))
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        Queue<Integer> heap = new PriorityQueue<Integer>((a,b)->(a-b));
        
        for(int n : nums) {
            
            heap.add(n);
            if(heap.size()>k) heap.poll();
            
        }
        
        return heap.poll();
    }
}
