//https://leetcode.com/problems/kth-largest-element-in-an-array/
/*
Time: O(nlogk) where n = nums.length
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class kthlargestInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // minHeap
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k)
                q.poll();
        }
        return q.peek();
    }

}
