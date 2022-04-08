import java.util.PriorityQueue;

/**
 * space is O(n)
 * time is nlog(n)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for(int n : nums) {
            pq.add(n);
        }
        while(k > 1) {
            pq.remove();
            k--;
        }
        return pq.remove();
    }
}