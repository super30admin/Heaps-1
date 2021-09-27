// Time Complexity : O(n log(k) )
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Min Heap implementation O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// ******************************************
// Time Complexity : O(n log(n-k) )
// Space Complexity : O(n - k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Max Heap implementation O(nlog(n-k))
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min( pq.poll(), result );
            }
        }
        return result;
    }
}