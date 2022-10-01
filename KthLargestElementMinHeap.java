// Time complexity: O(Nlogk) as N for interating the element and logk of adding to the heap (as it has to heapify)
// Space complexity: O(k) as the heap will contain at most k elements

// Approach: we use a min heap of k elements, that way whenever the heap size is greater than k, we remove the top most element. This way the smallest elements will keep getting removed from the top and only the k largest elements will remain in the min heap. The topmost element in heap will be our answer

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       for (int i : nums) {
           minHeap.add(i);
           if (minHeap.size() > k) {
               minHeap.poll();
           }
       }
       return minHeap.poll();
    }
}