/**
 * Time Complexity - O(n logK)  n= array length k = number of elements in heap
 * Space Complexty - O(k
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);

        for(int num : nums){
            if(minHeap.size() >=k){
                if(minHeap.peek() < num){
                    minHeap.add(num);
                    minHeap.poll();
                }
            }else{
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }
}