// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Use min Heap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> q= new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
