//TC:nlogk
//SC:O(1)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> p = new PriorityQueue<>((t1,t2)->t1-t2);
        
        
        for(int i=0;i<nums.length;i++)
        {
            if(p.size()<k)
               p.add(nums[i]);
            else
            {
            
              if(p.peek()<nums[i])
                 {
                   p.remove();
                   p.add(nums[i]);
                 } 
            }
        }
          
         
            
         return p.peek();   
    }
}