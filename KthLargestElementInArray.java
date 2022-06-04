// Time Complexity :O(N.LogK), N = nums.length
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>  heap = new PriorityQueue<>();
        for(int n : nums) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }
}
