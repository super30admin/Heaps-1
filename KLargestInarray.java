// Time Complexity : O(n*log(k)) 
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Usin MinHeap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek(); 
    }
}
