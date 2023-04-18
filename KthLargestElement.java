// The time complexity of this implementation is O(Nlog K) where
// N is the length of nums and K is the value of k
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        int result = solution.findKthLargest(nums, k);
        System.out.println("Test case : " + (result == expected));

    }
}