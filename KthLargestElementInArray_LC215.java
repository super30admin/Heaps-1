/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(nlogk)
Space Complexity - O(k)
 */
import java.util.PriorityQueue;

public class KthLargestElementInArray_LC215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length - k +1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  b-a);
        int kLargest = 0;
        for(int i = 0 ; i< nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > len){
                pq.poll();
            }
        }


        return pq.poll();
    }
}
