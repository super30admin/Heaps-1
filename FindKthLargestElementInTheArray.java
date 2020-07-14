package s30Coding;
import java.util.*;

//Time Complexity :- O(nlog(k))
//Space Complexity :- O(k)

public class FindKthLargestElementInTheArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length;i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
