// Time Complexity : O(nlogk) n is number of elements k as in the kth largest element
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Kthlargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {        
          PriorityQueue<Integer> pq = new PriorityQueue<>();  // Min Heap
           for(int num:nums)
           {
               pq.add(num);
               if(pq.size()>k) // Size exceeds k poll the minimum element
               {
                   pq.poll();  
               }
           }
            
            return pq.poll(); // top of the heap is n-k th  smallest i.e k th largest element
        }
    }
}
