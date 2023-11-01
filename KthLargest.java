// Time Complexity : O(N) where N is length of input array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num: nums){

            queue.add(num);

            if(queue.size() > k){

                queue.poll();
            }
        }
        return queue.peek();
    }
}