import java.util.PriorityQueue;

//Time Complexity : O(nlogk)
//Space Complexity : O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //put elements in queue
        for(int num : nums){
            pq.add(num);
            //if queue size is greater than k size then element is second last element
            if(pq.size() > k){
                pq.poll();
            }
        }
        //return top element
        return pq.peek();
    }
}