import java.util.PriorityQueue;

public class kthLargestElement {
    /*
     * TC : O(N* log(N-k)) where N is the length of the array
     * SC : O(N-K)
     * LC : yes
     * Problems : No
     */

    public int findKthLargest_mAXHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num); //O(log(n-k))
            if (pq.size() > nums.length - k) {
                result = Math.min(result, pq.poll());
            }

        }
        return result;

    }


    /*
     * TC : O(N* logk) where N is the length of the array
     * SC : O(K)
     * LC : yes
     * Problems : No
     */
    public int findKthLargest_mINHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();

    }
}
