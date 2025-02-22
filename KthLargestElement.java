import java.util.PriorityQueue;

// Time Complexity: O(nlogk)
// Space Complexity: O(k)

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k){
        int size = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int i = 0; i < k ;i++){
            minHeap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

}
