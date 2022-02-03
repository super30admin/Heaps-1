// Time Complexity : O(nlog(k)) where k is provided as input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Mininum Heap - smallest element is maintained at the top of the stack
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default comparator is for (a,b) -> a-b
        for(int n : nums){
            pq.add(n);
            // if heap size exceeds k
            if(pq.size() > k){
                // remove the extra element from the heap
                pq.poll();
            }
        }
        // retutn the top of the heap to get the kth largest element
        return pq.peek();
    }
}