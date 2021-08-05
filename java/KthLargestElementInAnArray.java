// Time Complexity : O(nlogn) for sorting
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int len = nums.length;
        int klargestindex = len - k;
        return nums[klargestindex];
    }
}

-----------Approach2----------------------
// Time Complexity : O(nlogk) log k for internal heapify for n num of elements
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        //MinHeap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
-----------------------Approach 3---------------------------
// Time Complexity : O(nlog(n-k)) log (n-k) for internal heapify for n num of elements
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        //MaxHeap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > nums.length - k) {
                result = Math.min(queue.poll(), result);
            }
        }
        return result;
    }
}