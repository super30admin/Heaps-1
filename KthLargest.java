import java.util.PriorityQueue;

// Construct min heap of size k and if it exceeds pop the min element and add the new element + heapfiy
// TC- O(nlogk) - logk for heapify which will perform for n elements
// If we use max heap. store n-k elements and have a result variable because this will have all max elements popping out
// TC - o(nlog(n-k))
// sc - O(k) since heap uses k space

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            pq.add(num);
            while (pq.size() > (n - k)) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }



 /*       public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.add(num);
                while (pq.size() > k) {
                    pq.poll();
                }
            }
            return pq.peek();

      }*/

}