import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargestMinHeap(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);

            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }

    public int findKthLargestMaxHeap(int[] nums, int k) {

        int result = Integer.MAX_VALUE;
        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num: nums) {
            pq.add(num);

            if (pq.size() > nums.length - k) result = Math.min(result, pq.poll());
        }

        return result;
    }
}
