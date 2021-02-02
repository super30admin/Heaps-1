// Time Complexity : O(n log k), n = length of array
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a Min Heap of size k, and add elements from array and check if the capacity of the heap is exceeded. If capacity is exceeded, poll() will remove the minimum value. Since the PriorityQueue is of size k, the kth largest element will be at top if the PriorityQueue.

public class KthLargestElementInAnArray {
    // Solution 1 : Min Heap
    public int findKthLargest(int[] nums, int k) {
        if(nums == null) return -1;
        
        //Min Heap
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> a - b);
        
        for(int i = 0; i < nums.length; i++){
            q.add(nums[i]);
            
            if(q.size() > k){
                q.poll();
            }
        }
        
        return q.peek();
    }

    // Solution 1 : Max Heap
    // public int findKthLargest(int[] nums, int k) {
    //     if(nums == null) return -1;
        
    //     //Max Heap
    //     PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 0; i < nums.length; i++){
    //         q.add(nums[i]);
            
    //         if(q.size() > nums.length - k){
    //             min = Math.min(min, q.poll());
    //         }
    //     }
        
    //     return min;
    // }
}
