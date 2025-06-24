// Approach (Min-Heap / PriorityQueue):
// Maintain a min-heap of size k, so it always holds the k largest elements seen so far.
// After processing all elements, the top of the heap (peek()) will be the k-th largest.

// Time Complexity:
// O(n log k) where n is the number of elements in nums.
// Each insert/remove operation on the heap is O(log k).

// Space Complexity:
// O(k) for the heap size.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums){
            pq.add(x);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
