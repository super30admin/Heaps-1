import java.util.PriorityQueue;

public class KthLargest {
    //Time comeplxity: O(NlogK)
    //space Complexity: O(N)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i< nums.length; i++){
            queue.offer(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}
