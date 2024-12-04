import java.util.PriorityQueue;
// Time Complexity: nlog(n) to heapify n elements and klog(n)// to maintain the order for k elements and apply heapify
// Space Complexity: o(k); since the size of heap is maintained to k always
public class problem1 {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> a-b);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        if (pq.size() > k) {
            pq.poll();
        }


        return pq.peek();

    }
}
