// Time Complexity : O(N log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class kthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new  PriorityQueue<Integer>((a, b) -> a -b);
        
        for (int num: nums) {
            heap.add(num);
            if(heap.size() > k) 
                heap.poll();   
        }
        
        return heap.poll();
    }
}
