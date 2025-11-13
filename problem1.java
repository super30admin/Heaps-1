// Time Complexity : O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

/* Approach
 * we are usig min heap in the PriorityQueue 
 * idea here is to only make the queue of size and keep removing the root every time 
 * queue size is k +1, becuase at size k because its a min heap all the big element will be at the bottom of the tree
 * and at kth size that element will be kth highest among elements, so as we keep adding 
 * nums will keep rearranging and finally we will have queue that contains all largest nums in the
 * nums and at root will be the smallest in other word kth largest
 * 
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}