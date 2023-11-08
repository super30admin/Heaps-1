/* Time Complexity : O(nlog k)
 *	n - length of array - nums
 * 	k - kth largest element */
/* Space Complexity : O(k) 
 *  k - size of the priority queue - limited to k */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

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