// Time Complexity : O(nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        //sorts with smallest coming out first
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //keep queue under k elements, the top will be the kth largest
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        //return the top
        return pq.peek();
    }
}