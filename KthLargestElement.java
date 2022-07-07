/*
This solution uses a MaxHeap to get the Kth largest element in the array. We maintain a MaxHeap of size N-K+1. This is because
once we are done processing the heap, the Kth largest element will be at the root of the heap, and it can simply be returned.

Did this code run on Leetcode: yes

*/
class Solution {
    //Time Complexity: O(nlog(n-k+1))
    //Space Complexity: O(n-k+1)
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int n = nums.length;
        
        for (int num: nums)
        {
            pq.add(num);
            
            if(pq.size() > n - k + 1)
            {
                pq.poll();
            }
        }
        
        return pq.peek();
        
    }
}