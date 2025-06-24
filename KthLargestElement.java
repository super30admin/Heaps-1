//time complexity- O(nlogK)

//space complexity- O(k)
import java.util.*;
public class KthLargestElement {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(k +" largest element in array is: "+ findKthLargest(nums, k));
    }
}
