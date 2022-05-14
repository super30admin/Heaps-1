//Time Complexity: O(N Log K )
//Space Complexity: O(K)

import java.util.*;
public class KthLargestElement
{
    public static int kthLargest(int nums[],int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0;i<k;i++)
        {
            pq.add(nums[i]);
        }

        for(int i = k;i<nums.length;i++)
        {
            if(nums[i]>pq.peek())
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String args[])
    {
        int[] nums  = {1,2,3,4,5,6};
        int k = 2;

        System.out.println(kthLargest(nums,k));
    }
}