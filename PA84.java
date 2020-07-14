//Leetcode: 215. Kth Largest Element in an Array
//Time Complexity; O(nlogk) , n is the size of nums and k is the heap size
//Space Complexity: O(k) , where k is the size of heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();    
        for(int n: nums){
            pq.offer(n); 
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
        
    }
}