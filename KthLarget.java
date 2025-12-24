import java.util.PriorityQueue;
class KthLarget {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < len; i++)
        {
            minHeap.add(nums[i]);
            if(minHeap.size() > k)
            {
                // polls min - the root - so that way k larget are maintained in min heap
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}