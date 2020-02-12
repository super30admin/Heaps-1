// Time Complexity : O(nlogk) where n is the length of the nums array
// Space Complexity : O(k) for heap 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class kthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            }
            else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.poll();
    }
}