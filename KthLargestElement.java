//Problem 82 : Kth Largest Element in an Array
//TC: O(nLogK), n means number of elements and k stands for heap size
//SC: O(k)

/*Steps

  Bruteforce: //TC: O(nLogn) | O(1) - Sort the array and return n-k element

  //Go with this
  Optimised I : //TC: O(KlogK)// SC:O(K) - Just choose min heap. iterate over given input and add it to the PQ. If PQ size greter than the k, poll the element. Finally return the peek element

  Optimised II :  TC: O(KlogK)// SC:O(K) - With peek comparision that if new number is greater than the current peek poll the existing one and insert the new one

*/
/*Note : 1) This question can be done using MaxHeap also, just maintain heap size of n-k+1 and return peek. TC:O(nlog(n-k+1)) | SC:n-k+1;
         2) If asked to find kth smallest element just create max heap of size k and return the peek element 
*/

import java.util.*;
class Solution82 {
    public int findKthLargest(int[] nums, int k) {
      
        if(nums==null || nums.length==0) return 0;
        
        //Without Peek Comparison - Just choose min heap. iterate over given input and add it to the PQ. If PQ size greter than the k, poll the element. Finally return the peek element
        //Go with this
        return minHeap(nums,k);
        
        //Note : If using max heap, maintain maxheap size n-k+1
        
       //With peek comparision that if new number is greater than the current peek poll the existing one and insert the new one
       //return optimised(nums,k); 
    }
    
    private int minHeap(int[] nums,int k){
        //TC: O(KlogK)// SC:O(K);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            
            if(minHeap.size()>k){
                minHeap.poll();
            }
            
        }
        return minHeap.peek();
    }
    
    
    
    //Optimised using Priority Queue
    private int optimised(int[] nums,int k){
        //TC: O(KlogK)// SC:O(K);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        
        
        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
    
    
    //Bruteforce
    //TC: O(nLogn) | O(1) 
    private int bruteforce(int[] nums,int k){
        
        Arrays.sort(nums);
        
        return nums[nums.length-k];
    }
}
