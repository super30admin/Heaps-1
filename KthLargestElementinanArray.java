//Leetcode: https://leetcode.com/submissions/detail/628329606/
//Time: O(nlogk)
//Space: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
       
        
       
        return pq.peek();
    }
}