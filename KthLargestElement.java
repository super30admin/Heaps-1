//solved successfully on leetcode n faced no issues
//tc : O(nlogk) sc:O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>heap = new PriorityQueue<>();
        for(int num : nums){
            heap.add(num);
            if(heap.size() >k){
                heap.poll();
            }
        }
        return heap.peek();
        
    }
}