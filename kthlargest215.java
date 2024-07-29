// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // create a min heap,
        // if size === k
        // if current is greater than top, pop and push
        // else
        // push

        Queue<Integer> pq = new PriorityQueue<>();
        for(int current: nums){
            if(pq.size()<k){
                pq.offer(current);
            }
            else{
                if(pq.peek()<current){
                    pq.poll();
                    pq.offer(current);
                }
            }
        }
        return pq.poll();
    }
}
