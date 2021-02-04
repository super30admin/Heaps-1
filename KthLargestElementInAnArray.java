import java.util.PriorityQueue;

// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding heaps

// Your code here along with comments explaining your approach
public class KthLargestElementInAnArray {


    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();//create minHeap using priority queue

            for(int i: nums){
                minHeap.add(i); //add current number
                if(minHeap.size() > k) minHeap.remove();//if minHeap size exceeds k, remove value at root
            }
            return minHeap.remove();//retrun kth largest element at the root
        }
    }
}
