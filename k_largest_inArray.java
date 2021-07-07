// Time Complexity : n log k --> n is the size of array and k is the size of min heap. 
// Space Complexity : O(k) min heap holds k element at any point of time.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length ==0)
            return -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        // Add first k elements in the heap.
        for(int i=0; i<k;i++){
            minHeap.add(nums[i]);
        }
        
        // Get the minimum from heap and replace with greater value in array.
        for(int i=k;i<nums.length;i++){
            int minVal = minHeap.peek();
            if(nums[i] >=minVal){
                minHeap.remove(minVal);
                minHeap.add(nums[i]);
            }
        }
        // Heap now hold final k elements. Minimum in the heap will be the result to be returned.
        return minHeap.peek();
    }
}
