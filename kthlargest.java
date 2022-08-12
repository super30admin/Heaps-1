// Time Complexity : o(klogk)
// Space Complexity : o(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
          pq.add(num);
            if(pq.size()>k){
            pq.poll();
            }
        }
        return pq.poll();
    }
}