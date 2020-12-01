// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Used priority queue which works as min heap in the background to find the kth largest element in the given array.
//Adding to the queue till it reaches the limit of K and removing if it exceeds.
import java.util.PriorityQueue;



public class findKthLargestElement {



    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> myQ = new PriorityQueue<>();

        for(int i =0;i<nums.length;i++){
            myQ.add(nums[i]);
            if(myQ.size() > k){
                myQ.poll();
            }
        }
        return myQ.peek();
    }
}
