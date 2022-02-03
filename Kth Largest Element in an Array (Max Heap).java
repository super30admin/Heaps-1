// Time Complexity : O(nlog(n-k)); where l is provided as an input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Maximum Heap - largest element is maintained at the top of the stack
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
        int min = Integer.MAX_VALUE;
        
        for(int n : nums){
            pq.add(n);
            // if heap size exceeds n - k
            if(pq.size() > nums.length - k){
                // remove the extra element from the heap and compare it with current min
                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}