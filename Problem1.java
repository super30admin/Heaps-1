//MinHeap Time: O(nlogk)
//MinHeap Space: O(k)
//MaxHeap Time: O(nlog(n-k))
//MaxHeap Space: O(n-k)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for(int i=0;i<k;i++){
//             minHeap.add(nums[i]);
//         }

//         for(int i=k;i<nums.length;i++){
//             if(nums[i]>minHeap.peek()){
//                 minHeap.remove();
//                 minHeap.add(nums[i]);
//             }
//         }
//         return minHeap.peek();
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        int result = Integer.MAX_VALUE;

        for(int num:nums){
            maxHeap.add(num);
            if(maxHeap.size()>nums.length-k) result = Math.min(result, maxHeap.poll());
        }
        return result;



    }
}