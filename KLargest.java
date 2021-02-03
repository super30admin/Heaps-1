// Time Complexity : 0(n log k) n is len of array and k is heap size, it takes log k time to add/remove element from heap
// Space Complexity : 0(k) that is the size of heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class KLargest {
    public int findKthLargest(int[] nums, int k) {
        //min heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)-> a-b);

        //put nums in heap
        for(int n: nums)
        {
            heap.add(n);

            //keep heap size to k
            if(heap.size() > k)
            {
                heap.poll();
            }
        }

        return heap.poll();
    }
}