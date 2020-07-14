# Time Compelxity : O(NlogK) where N is number of elemets in inputs and Log K for heap
# Space Complexity :O(K) where K is the capacity of stack

class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i< nums.length; i++)
        {
        
          if( pq.size()<k)
          {
            pq.add(nums[i]);  
          }
          
          else
          {
              if (nums[i] > pq.peek())
              {
                  pq.poll();
                  pq.add(nums[i]);
              }
        
        }
    }
    
    return pq.peek();
    
}
}