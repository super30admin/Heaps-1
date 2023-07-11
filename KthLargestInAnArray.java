import java.util.PriorityQueue;

public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // PriorityQueue <Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestInAnArray solution = new KthLargestInAnArray();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        // Find the kth largest element
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + kthLargest);
    }
}