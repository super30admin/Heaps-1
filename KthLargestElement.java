import java.util.PriorityQueue;

//Time complexity: O(nlogk)
//Space complexity: O(k) , Heap space 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) { // min heap of size k, if size is>k,
                pq.poll(); // then remove the smallest element
            }
        }
        return pq.poll(); // result is at the root of the min heap

    }
}