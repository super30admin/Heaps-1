// Leetcode 215: Kth largest element in an array
// Time - O(nlogk)
// space - O(k) (heap size)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> a - b);
        
        
        for(int num: nums){
            
            pq.add(num);
            if (pq.size() >  k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}