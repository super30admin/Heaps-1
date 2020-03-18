//Time Complexity: O(Nlogk) 
//Space Complexity: O(k) - at a time there are only k elements in the heap
//LeetCode: Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)return Integer.MAX_VALUE;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i<k; i++)minHeap.add(nums[i]);
        
        for(int i =k; i<nums.length;i++){
            if(nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
        
    }
}
