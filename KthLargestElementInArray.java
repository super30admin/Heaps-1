// Time Complexity : O(n(log(n-k)))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
     public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new LinkedList<>();
    
           // method1 min heap
    //     for(int num : nums){
    //         pq.add(num);
    //         if(pq.size()>k){
    //             pq.poll();
    //         }
    //     }
    //     return pq.poll();
    
        // method2 max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
         int n = nums.length;
         int min = Integer.MAX_VALUE;
        for(int num : nums){
            pq.add(num);
            if(pq.size()>n-k){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}