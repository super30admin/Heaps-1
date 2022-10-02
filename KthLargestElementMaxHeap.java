// Time complexity: O(nLog(n-k)) as we are iterating over the entire array and heapifying n-k elements
// Space complexity: O(n-k) as our heap is of size n-k

// Approach - max heap approach. We keep n-k elements in heap. We pop elements when heap is greater than n-k. We know that whenever we pop the element, it is one of the k largest elements. So we need to keep a min variable and get the minimum out of the k largest elements

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
       int min = Integer.MAX_VALUE;
       for (int i : nums) {
           maxHeap.add(i);
           if (maxHeap.size() > nums.length-k) {
               min = Math.min(min,maxHeap.poll());
           }
       }
        return min;
    }
}