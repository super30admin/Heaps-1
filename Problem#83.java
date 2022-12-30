// Kth Largest Element in an Array

// MinHeap solution
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// MaxHeap solution
// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int num: nums){
            pq.add(num);
            if(pq.size() > (n-k)){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}