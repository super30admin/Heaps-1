
// Time Complexity : O(n * log k) --> min heap on k elements
// Space Complexity : o(k)  --> min heap stores k values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap
        for(int num : nums){
            minHeap.add(num);
            if(minheap.size() > k){    // more than k elements remove the element
                minHeap.remove();    // min elements removed
            }
        }
        return minHeap.peek(); // as we are adding  and removing n-k elements from min heap the top element is kth highest
    }
}

// Time Complexity : O(n * log (n-k) )--> min heap on k elements
// Space Complexity : o(n-k)  --> min heap stores k values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
    class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);   // max heap
       int min = Integer.MAX_VALUE;
        for(int num : nums){
            maxHeap.add(num);    // add to heap always max element at top
            if(maxHeap.size() > nums.length- k){
              min = Math.min(min,maxHeap.remove());  // max elements are popped and store minimum of them 
            }
        }
        return min;  // kth highest elememt is in min
    }
}
