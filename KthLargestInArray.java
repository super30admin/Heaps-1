// Time Complexity : O(nlogk)
// Space Complexity : O(k) At max we store k elements in the heap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class KthLargestInArray {
    
    // Create a min heap to keep track of the elements.
    // If the size of the heap is greater than k, then we remove the top element.
    // Since the top element is the minimum element, we are accumulating the max elements at the bottom of the heap.
    // In the end we will have k max elements in the heap in the ascending order.
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}
