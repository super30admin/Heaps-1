// Time Complexity : kLog(K) + (N-k)LogK = NlogK
// Space Complexity : O(K) to store K heap elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved after class


// Your code here along with comments explaining your approach
//priority queue using minHeap

class Solution {

    //T: kLog(K) + (N-k)LogK = NlogK
    //S: O(K) to store K heap elements
    
    public int findKthLargest(int[] nums, int k) {
       
        //base check
        if(nums == null || nums.length == 0) return 0; //ask interviwer what to return
        
        //initialize priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //insert the first k elements in priority queue
        for(int i=0; i<k; i++){
            minHeap.add(nums[i]);
        }
        
        //since priority queue keeps the smallest element at the front to pop check whether the smallest element is lower than the current element in the array
        for(int i=k; i<nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
}