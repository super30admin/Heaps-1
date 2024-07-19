import java.util.PriorityQueue;

/***
 TC - O(nlog(n-k))
 SC - O(n-k)
 */
class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        //Using max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int num : nums) {
            pq.add(num);
            if(pq.size() > (n-k))
                min = Math.min(min, pq.poll());
        }

        return min;

    }
}