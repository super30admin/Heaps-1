import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class KthLargest {

    // Using min heap
    // TC: O(n * log k) n - nums.length k - it is an input
    // SC: O(k) at a time we'll be holding only k elements in q queue
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        // Min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.add(num);

            // By putting this condition, we are ignoring the elements which are smaller than kth largest element
            // e.g. if we have 3,2,1,5,6,4 and k = 2
            // by keeping queue size as 2, we will be holding only 2nd largest and 1st largest only
            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};

        KthLargest k = new KthLargest();
        int answer = k.findKthLargest(nums,2);
        System.out.println("answer = " + answer);
    }

}
