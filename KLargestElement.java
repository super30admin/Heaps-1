// Time Complexity : O(n) n is the nums array length
// Space Complexity : O(k) heap space limited to k elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        for(int n:nums){
            if(heap.size() < k)
                heap.add(n);
            else{
                if(heap.peek() < n )
                    heap.add(n);
                if(heap.size() > k)
                    heap.poll();
            }
        }
        return heap.poll();
    }
}
