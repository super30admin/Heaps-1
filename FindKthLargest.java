import java.util.PriorityQueue;

/*
## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

Time Complexity :   O (N log(n-k)) 
Space Complexity :  O (n-k) 
Did this code successfully run on Leetcode :    Yes (215. Kth Largest Element in an Array)
Any problem you faced while coding this :       No

 */
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // take max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        
        for(int num: nums){
            pq.add(num);
            
            if(pq.size() > n-k){
                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}