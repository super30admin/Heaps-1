/* Time: O(N logk) where N = no of elements in nums
Space: O(k) -> k elements in PQ
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0)
            return -1;
        
        //create min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        //the top element is kth largest
        return pq.peek();
    }
}