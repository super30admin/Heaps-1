//TC: O(nlogk) logk for each element in n-array
//SC:O(K) - for queue
//successfully run in leetcode:yes
//used a min heap priority queue of and popped the element id its size is greater than k. return the 
//peek element of the k sized queue at the end.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}