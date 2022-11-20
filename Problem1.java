
import java.util.*;

class Problem1 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        int result = Integer.MAX_VALUE;
        while (k > 0) {
            result = pq.remove();
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 9, 8, 7, 6, 5, 4 };
        int k = 3;
        System.out.print(findKthLargest(nums, k));
    }
}