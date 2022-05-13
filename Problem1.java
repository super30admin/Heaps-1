import java.util.PriorityQueue;

public class Problem1 {

    //Min Heap
    // TC : O(nlogk)
    // SC : o (k)
    //where n = length of nums and k = value of k

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    //max Heap
    // TC : O(nlogk)
    // SC : o (n-k)
    //where n = length of nums and k = value of k
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > nums.length - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
