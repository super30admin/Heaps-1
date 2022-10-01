// Time Complexity : O(NLogK) where N is total number of lists and k is the num of elements in heap
// Space Complexity: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use priority Queue (Max heap), add elements to pq, and once the size of pq equals to k, start polling
(the biggest elements get removed) leaving the kth largest element when finally polled
*/
public class KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            return a-b;
        });

        for(int num:nums){
            pq.offer(num);
            k--;
            if(k<0)
                pq.poll();
        }

        return pq.poll();
    }
}
