// using minheap:
// TC: O(n*log k )=> n times * heap of size k
// SC: O(K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Create a min heap of size k , such that the we compare the root node with incoming elements and decide if this number should be part of the heap or not. In the end we will have a heap of size k , which means the root of that heap (which is a min heap is the kth largest element)
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num: nums)
        {
            if(pq.size() == k)
            {
                int kthLargest = pq.peek(); // checking root of the min heap
                if(num < kthLargest) // if incoming is less that kthLargest
                {
                    //ignore
                }
                else{
                    pq.remove();
                    pq.add(num);
                }
            }
            else{
                pq.add(num);
            }

        }
        return pq.peek();
    }
}