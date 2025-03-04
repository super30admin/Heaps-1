//Time Complexity: O(nlogk) where n is the length of the array
//Space Complexity: O(k)
//In this approach, we use a min-heap (Priority Queue) of size k. 
//As we iterate through the array, we insert each element into the priority queue. 
//If the queue exceeds size k, we remove the smallest element from the heap. After processing all elements, the kth largest element will be at the top of the priority queue.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);//logk
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}