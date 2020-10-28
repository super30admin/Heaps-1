// Time Complexity : O(N) - As we traverse through all the elements of the array
// Space Complexity : O(N) - As we use a  priority queue data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0;i <nums.length;i++){
            queue.add(nums[i]);
        }
        for(int j = 0;j < k - 1;j++){
            int m = queue.poll();
        }
        return queue.peek();
    }
}
// Your code here along with comments explaining your approach