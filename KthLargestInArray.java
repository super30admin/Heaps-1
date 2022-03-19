// Time Complexity : O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Add all the elements in reversed priority queue
//When the size of heap becomes greater than k then pop
//Every time the min element is getting popped
//When all the elements are checked all the min elements less than k are popped
//Now the kth largest element would be at the root of the pq, we will return this.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int x: nums){
            pq.add(x);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}