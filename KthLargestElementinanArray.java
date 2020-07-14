// Time Complexity : O(n log k) 
// Space Complexity : O(k) elements in priority queue. 

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We use a priority queue and remove n-k elements of the priority queue. After adding n elements we remove the element of the queue and return it. 
//Runtime: 4 ms, faster than 65.33% of Java online submissions for Kth Largest Element in an Array.
//Memory Usage: 39.8 MB, less than 59.85% of Java online submissions for Kth Largest Element in an Array.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>(); 
       
        for (int n:nums){
            pqMinHeap.add(n);
            if (pqMinHeap.size()>k){ //remove (n-k) elements
                pqMinHeap.remove();
            }
        }
       return  pqMinHeap.remove();
    }
}

//another solution

//using Quick select algorithm
//Runtime: 2 ms, faster than 79.50% of Java online submissions for Kth Largest Element in an Array.
//Memory Usage: 41.8 MB, less than 14.91% of Java online submissions for Kth Largest Element in an Array.
import java.util.Random;
class Solution {
    public int findKthLargest(int[] nums, int k) {
       if (nums==null||nums.length==0)return Integer.MIN_VALUE;
       return qSelect(nums,0,nums.length-1,nums.length-k);      
   }

  private int qSelect(int[] nums,int left,int right, int k){
     if (left==right) return nums[left];
     int pIndex=new Random().nextInt(right-left+1)+left;
     pIndex=partition(nums, left,right, pIndex);
     if (pIndex==k)return nums[pIndex];
     else if (pIndex>k)
       return qSelect(nums,left, pIndex-1,k);
     else 
       return qSelect(nums,pIndex+1,right,k);
  }

  private int partition(int[] nums, int left, int right, int pIndex){
    int pivot=nums[pIndex];
    swap(nums,pIndex,right);
    int pLeft=left;
    for (int i=left;i<right;i++){
       if (nums[i]<=pivot){
          swap(nums,pLeft, i);
          pLeft++;  
       } 
    }
    swap(nums,pLeft, right);
    return pLeft;
  }
  
  private void swap(int[] a, int i, int j){
    int tmp=a[i];
    a[i]=a[j];
    a[j]=tmp;  
  }

}