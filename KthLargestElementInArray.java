
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>((a, b) -> b - a);
        for (int number : nums) {
            pq.add(number);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}
