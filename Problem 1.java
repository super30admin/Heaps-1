//Time Complexity: O(N log k) where N is the length of nums array 
//Space Complexity: O(k)

//Successfully runs on leetcode: 4 ms

//Approach: We are using Min-heap to keep a track of k elements at a time. So, in a min-heap, at a time, there will be only k
//elements that will be the larger elements than the element which is at k+1 index after heapify is done and that element
//will be removed from the heap as the size of the heap becomes greater than k. In the end, we can return the kth largest
//element by peeking the heap.


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums)
        {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();     
        }
        return pq.peek();
    }
}