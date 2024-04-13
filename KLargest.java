// TC: O(nlog(n-k))
// SC: O(n-k)

public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > n-k) {
                result = Math.min(pq.poll(), result);
            }
        }

        return result;
    }
}