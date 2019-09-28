/*
The time complexity is O(n*logk) where n is length of nums array. The space complexity is O(k)

The intuition here is to maintain a priority queue of size k where the least element of which is at top is the kth largest element
of the array.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:nums){
            if(pq.size()==k){
                if(pq.peek()<num){
                    pq.poll();
                    pq.offer(num);
                }
            }
            else{
                pq.offer(num);
            }
        }

        return pq.poll();
    }
}