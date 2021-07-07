// Time Complexity: O(nlogk) where n is the number of elements in nums
//Space Complexity: O(k) since we are maitaining PQ to hold k elements

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}