    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/
    Time Complexity for operators : o(nlogk) ..
    Extra Space Complexity for operators : o(n*logk) ... 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach:
                              
            Approach :- 
                    A. Create a minheap of an element.
                    B. During insert itself check for the size of heap is greate than k or not
                    C. If it is greater that means we reached and need to remove  the  top element.
                    D. AFter each insert and remove, You will get the top element on the top of an heap.\
       */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums){
            
            minHeap.add(num);
            
            if(minHeap.size()>k)
                minHeap.remove();
        }
        
        return minHeap.remove();
    }
}