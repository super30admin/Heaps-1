import java.util.PriorityQueue;

public class KthLargestElement {

     //If question says largest choose minHeap
    /*public int findKthLargest(int[] nums, int k) {
      //MinHeap
      //Time: O(nLogk)
      //Space: O(k)
        PriorityQueue<Integer> pQueue=new PriorityQueue<>();
        //At the end k max elements are left in the heap
        //with minimum among them at the top.
        for(int i=0;i<nums.length;i++)
        {
            pQueue.add(nums[i]);
            //making sure pQueue's size is less than k
            if(pQueue.size()>k)
            {
                pQueue.poll();
            }
        }
        
        return pQueue.poll();
    }*/
    public int findKthLargest(int[] nums, int k) {
        //MaxHeap
        //Heap maintains Top n-k elements 
        //we want to find out n-k+1th element in sorted order
        //minimum among element popping from queue would be n-k+1th element
         //Time: O(nLog(n-k))
      //Space: O(n-k)
        PriorityQueue<Integer> pQueue=new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            pQueue.add(nums[i]);
            if(pQueue.size()>(n-k))
            {
               result = Math.min(result,pQueue.poll());
            }
        }
        
        return result;
    }

}