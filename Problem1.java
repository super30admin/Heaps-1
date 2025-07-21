// Problem1 
// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)


// Time Complexity : O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we keep on adding the elements to a min heap, of size k, so every time the heap size is greater than k, we remove
// smallest cause we need kth largest so k+1 largest wont be our answer.

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         //[3,2,4,5,1]
//         //Arrays.sort(arr) ascending
//         //Arrays.sort(arr,(a,b)->a-b) descending
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int num: nums){
//             pq.add(num);
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         return pq.peek();
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //[3,2,4,5,1]
        //Arrays.sort(arr) ascending
        //Arrays.sort(arr,(a,b)->a-b) descending
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result=Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);
            if(pq.size()>nums.length-k){
                result = Math.min(pq.poll(),result);
            }
        }
        return result;
    }
}