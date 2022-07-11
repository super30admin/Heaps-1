/* Time Complexity: O(nlogk)
 * Space Complexity:O(k), k is min heap size
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);//logk
            if(pq.size() > k){//logk
                pq.poll();
            }
        }
        return pq.peek();
    }
}
