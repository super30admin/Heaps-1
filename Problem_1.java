// Time Complexity : O(n*log(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take max heap, and then if the size of heap is grater than, n-k then pop, compare the pop element, and find the min, and store it to the min variable, return min - as it will be the kth term from the top element.
// Your code here along with comments explaining your approach
// using max heap - prioeiryQueue ( reversing the pq)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}

// using min heap - priorityQueue - t: O(n*logk) s: O(k)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int num : nums){
//             pq.add(num);
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         return pq.poll();
//     }
// }