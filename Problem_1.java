// Time Complexity : O(nlogk) --adding n elements in priority queue
// Space Complexity :O(k) --in case of min heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for(int num : nums){
             pq.add(num);
             if(pq.size() > n - k){
                 result = Math.min(result, pq.poll());
             }
        }
        return result;
    }
}

//MinHeap based solution
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if(nums == null || nums.length == 0) return -1;
//by default minHeap
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         int n = nums.length;
//         for(int num : nums){
//              pq.add(num);
//              if(pq.size() > k){
//                  pq.poll();
//              }
//         }
//         return pq.poll();
//     }
// }