/**
 * TC: O(NlogK)
 * SC: O(k)
 * Approach: Brute force: Sort the array and return kth number from end
             Max Heap: Build a max heap of all elements from the array and remove k elements from the max heap
             MinHeap: Maintain a minHeap of k size of k greatest elements and return the root after all nums are processed
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        // Loop through nums
        for(int num : nums) {
            // Add current num to minHeap
            minHeap.add(num);
            // Maintain size of minHeap till k
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        // return kth largest
        return minHeap.remove();
    }
}
