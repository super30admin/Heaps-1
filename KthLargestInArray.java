import java.util.PriorityQueue;

// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



public class KthLargestInArray {

    // min heap solution 
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        
        for(int i:nums){
            heap.add(i);
            if(heap.size() > k){
                heap.poll();
            }
        }
    return heap.poll();
        
        
    }

  
    /*
    
    //Max-heap --> o(nlog(nums.length-k))
    
     public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b) -> b-a); 
        
        int result=Integer.MAX_VALUE;
        int n =nums.length;
        for(int i:nums){
            heap.add(i);
            if(heap.size() > (n-k){
                result=Math.min(result,heap.poll()); 
            }
        }
    return result;
        
        
    }
    
    
    
    */


}
