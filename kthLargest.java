// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * Push all the elements into a min heap of size k and pop the smaller elements whenever the size exceeds k
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(); //natural ordering-ASC (n1, n2) -> n1 - n2) - min at top
        for(int num: nums){
            q.add(num);
            // maintaining max heap - min element at top.
            if(q.size() > k){ 
                //have a q of k largest elements and remove others
                q.poll();
            }
        }
        // the top at the 1 will be the kth largest.
        return q.peek();
    }
}