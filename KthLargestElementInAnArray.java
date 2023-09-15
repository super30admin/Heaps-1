// tc = nlogk
//sc = O(k)

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        int obj1 = obj.findKthLargest(arr, k);
        System.out.println(obj1);
    }

    public int findKthLargest(int[] nums, int k) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int num : nums) {
        // pq.add(num);
        // if (pq.size() > k) {
        // pq.poll();
        // }
        // }
        // return pq.poll();

        // }

        // max heap

        PriorityQueue<Integer> pq = new PriorityQueue<>(((a, b) -> (b - a)));
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > n - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;

    }

}