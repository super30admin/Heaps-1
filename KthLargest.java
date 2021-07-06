import java.util.PriorityQueue;
// Time Complexity : O(nlogk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
We are maintaining a min heap of size k
everytime a new element is pushed in the priority queue and queue's size exceeds k, minimum element amongst the k+1 element is removed
when k=2, if 2 and 3 are in the pQueue, and 4 is encountered, 2 is removed
so we are left with 4 and 3 in the pQueue with 3 being the parent
that's how we are able to maintain 2 largest elements in pQueue with 2nd largest at the top.
*/
public class KthLargest{
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++)
        {
            pQueue.add(nums[i]);
            if(pQueue.size()>k)
            {
                pQueue.poll();
            }
        }

        return pQueue.poll();
    }

   public static void main(String[] args)
   {
       int[] nums={3,2,1,5,6,4};
       int k=2;
       System.out.println(findKthLargest(nums,k));
   } 
}