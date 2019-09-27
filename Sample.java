// Time Complexity: O(n)
// Space Complexity: O(n)

// Approach: Using min heap with priority queue.
// 1. For every number in the array, add it to the min heap
// 2. If the index of the number in the array >= k, extract the min from heap,
//  so that at the end of traversal, we have kth largest number at the head of heap.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(i>=k){
                pq.poll();
            }
        }
       return pq.poll();
    }
}
