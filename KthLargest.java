import java.util.*;
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> a-b);
        for(int each:nums){
            minheap.add(each);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        return minheap.poll();
    }
}
