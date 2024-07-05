/*
    LC - 215. Kth Largest Element in an Array
    TC - O(n logk)
    SC - O(k)
    Approach 1 - Using min heap
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/*
    LC - 215. Kth Largest Element in an Array
    TC - O(n log(n-k))
    SC - O(n - k)
    Approach 2 - Using the max heap
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);  // max heap
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            pq.add(nums[i]);
            if(pq.size() > n - k) {
                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}