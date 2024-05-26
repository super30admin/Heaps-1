import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Array.sort(arr);  //-> asc   //if we want to sort in desc order use comparator
        //Array.sort(arr, (a,b) -> b-a);

        //MinHeap(by default priority queue is minheap)
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int n = nums.length;
        // for(int num:nums)
        // {
        //     pq.add(num);
        //     if(pq.size() > k)
        //     {
        //         pq.poll();
        //     }
        // }

        // return pq.peek();

        //MaxHeap(use comparator) (a,b -> b-a)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for(int num:nums)
        {
            pq.add(num);
            if(pq.size() > n-k)
            {
                result = Math.min(pq.poll(), result);
                //pq.poll();
            }
        }

        return result;



    }
}