//time O(nlogk)
//space O(k) => O(1)
//approach: iterate over the array and push the k elements in the queue. Replace the current num with top of PQ is the current num is larger. Return the top element from PQ in the end

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(pq.size() == k) {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            } else {
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
