// Time Complexity :O(n Log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
 * 
 * using min heap of size k, O(n Log k) solution 
 * 
 * can also be solved using max head of size n-k , O(n Log (n-k))
 * 
 * should choose between min heap and max heap depending on lowest value of k or n-k for optimized solution
 *
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0) return -1;
        
        //use min heap of size k
        
        Queue<Integer> pQ = new PriorityQueue<>();
        
        for(int num: nums) {
            pQ.add(num);
            
            //if heap size cross k, remove min element (head of queue)
            if(pQ.size() > k){
                pQ.poll();
            }
        }
        
        //kth largest element will be at the head of queue, return it
        return pQ.peek();
    }
}