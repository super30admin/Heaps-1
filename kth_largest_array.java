//Time complexity is dependent on the size of heap and as we are just taking 
//K size - it would be O(nlogk)
//space complexity - O(k)
// using min heap -
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap 
//         for(int i=0;i<nums.length;i++){
//             pq.add(nums[i]);
//             if(pq.size()>k) pq.poll();
//         }
//         return pq.peek();
//     }
// }
//Time Complexity - O(nlog(n-k))
// Space Complexity - O(n-k)
//using max heap-
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // max heap -defined by comparator 
        int result =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>(nums.length-k)) result = Math.min(result, pq.poll());
        }
        return result;
    }
}