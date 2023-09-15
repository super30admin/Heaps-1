// Time complexity: O(N Log K) N:all the elements K:applied heapify for k elements.
// Space complexity: O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using MinHeap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}


// Time complexity: O(N Log (N-K)) N:all the elements N-K:applied heapify for N-K elements.
// Space complexity: O(N-K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using MaxHeap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num : nums){
            pq.add(num);
            if(pq.size() > n - k){
                result = Math.min(result , pq.poll());
            }
        }
        return result;
    }
}