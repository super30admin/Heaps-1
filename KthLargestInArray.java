//Time O(n log k)
//Space O(k)

/*
The solution uses a min-heap to efficiently track the top k largest elements in the array.
By iterating through each number, it adds elements to the heap and removes the smallest (root)
if the heap size exceeds k. This ensures the heap always contains the k largest elements seen so far.
After processing all elements, the root of the heap is the kth largest
* */




import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->a-b);
        for(int num:nums)
        {
            pq.add(num);

            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
