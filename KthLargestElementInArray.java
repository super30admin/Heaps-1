class Solution {
    // Time Complexity : O(nlogk)  n: nums and k: kth largest in nums
// Space Complexity : O(k)  priority queue size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use min heap of size k, so that when all elements are traversed, ans is the peek element
 */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k==0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}


class Solution {
    // Time Complexity : O(nlog(n-k))  n: nums and k: kth largest in nums
// Space Complexity : O(n-k)  priority queue size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Idea is that when you poll max heap , the max values will get removed.
 2. So Use max heap of size (n-k), so that when all elements are traversed, the removed elements will be k largest elements.
 */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k==0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > (nums.length-k)){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}
