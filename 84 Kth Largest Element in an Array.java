// Time Complexity : O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums)
        {
            pq.add(num);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}