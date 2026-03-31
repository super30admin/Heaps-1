    /**
    Time Complexity : O(N log K)
    Explanation:
    - We iterate through N elements
    - Each insertion/removal in heap takes O(log K)
    So total = O(N log K)

    Space Complexity : O(K)
    Explanation:
    Heap stores at most K elements.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried sorting the array which takes O(N log N).
    Optimized it using a min-heap of size K.
    The idea is to keep only the K largest elements in the heap,
    so the top element is the Kth largest.
    */
    class Solution {



        public int findKthLargest(int[] nums, int k) {
    
            // Min-heap
            PriorityQueue<Integer> q = new PriorityQueue<>();
    
            for (int num : nums) {
    
                q.add(num);
    
                // Keep heap size = k
                if (q.size() > k) {
                    q.poll();
                }
            }
    
            // Top of heap is kth largest
            return q.peek();
        }
    }