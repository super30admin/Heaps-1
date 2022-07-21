// Time Complexity : O(N * log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);

        for(int i: nums){
            heap.add(i);

            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}