/* Time Complexity : O(nlog (n-k))
 *	n - length of array - nums
 * 	k - kth largest element */
/* Space Complexity : O(n-k) 
 *  size of the priority queue - limited to n-k */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

 //MaxHeap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);
            if(pq.size() > (nums.length-k)){
				//kth largest ele will be smallest among (n-k) elements
                result = Math.min(pq.poll(), result);
            }
        }
        return result;
    }
}