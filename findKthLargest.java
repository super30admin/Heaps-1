/*
Time complexity : O(Nlogk).
Space complexity : O(k) to store the heap elements.

Approach - 1 using heap/priority queue
Runtime: 7 ms, faster than 27.70% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 42.6 MB, less than 5.89% of Java online submissions for Kth Largest Element in an Array.
*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((n1,n2)-> n1-n2);
        for(int i:nums)
        {
            heap.add(i);
            if(heap.size()>k)
                heap.poll();
        }
        return heap.peek();
    }
}






