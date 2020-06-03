//Time complexity : nlogk (n = size of nums array, k = size of priority queue)
//Space complexity : k (size of priority queue)
//Runs successfully on leetcode
//No problem

//Here we will be maintaining k elements in a priority queue, if number is greater than the smallest element in the list
//We will be removing the smallest element and will add the greatest element
//In the end, we will have k greatest element, smallest of them being on the top of the queue



import java.util.PriorityQueue;

public class Heaps_1_Problem_1_kthLargeElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i ++)
        {

            if(pq.size()<k)
            {
                pq.add(nums[i]);
            }
            else
            {
                if(nums[i] > pq.peek())
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }


        return pq.peek();
    }
}
