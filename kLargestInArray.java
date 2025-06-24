//use a min-heap to maintain the top k largest elements seen so far by always removing the smallest when the size exceeds k. The root of the heap (pq.peek()) gives the k-th largest element at the end.
//Time Complexity: O(n log k)
//Space Complexity: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
    return pq.peek();
    }
}