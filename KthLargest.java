/*
    Time Complexity - O(log(k))
    Space Complexity - O(k)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num: nums){
            pqueue.add(num);
            if(pqueue.size()>k){
                pqueue.poll();
            }
        }
       return pqueue.poll();
        
    }
}
