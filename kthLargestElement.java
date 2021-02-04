class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num:nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
//removing element from heap takes O(logk)
// Time Complexity: O(Nlogk)
//Space Complexity: O(k) // for storing elements on to heap

