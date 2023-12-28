
// Time complexity : O(nlogk)
// Space complexity : O(k)
import java.util.PriorityQueue;

class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}