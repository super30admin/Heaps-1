package Nov26;

import java.util.PriorityQueue;

class KthLargestElemInArray {
    public int findKthLargest(int[] nums, int k) {
        
        /*
        Time Complexity:
        O(n log k) where n is no.of elements in nums array and k is size of priority queue.
        
        Space Complexity:
        O(k) because we are using a priority queue of size k.
        
        Approach: 
        Min Heap of size k is used so that the lowest value to (n-k)th element from nums array are popped from the priority queue just when size of k is exceeded. At the end, priority queue will contain the largest 2 elements of nums array.
        
        */
        
        // edge
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();   
    }
}
