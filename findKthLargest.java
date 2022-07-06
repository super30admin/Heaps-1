// Time Complexity : Nlogk
// Space Complexity : O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num); //logk
            if(pq.size() > k){ //logk
                pq.poll(); //extract minimum
            }
        }
        return pq.peek();
    }
}
