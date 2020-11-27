//Time Complexity : O(nlogk) // n: nums of elements in the given array, k: size of PriorityQueue
//Space Complexity : O(k) // k: size of PriorityQueue
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.PriorityQueue;

import com.s30.satish.GFG.Node;

class Kth_Largest_Element_215 {
    // Min heap approach
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // PriorityQueue<>() is for min heap
        for(int num : nums)
        {
            pQueue.add(num);
            if(pQueue.size() > k)
                pQueue.poll();
        }
        return pQueue.peek();
    }

    // Max heap approach
  //Time Complexity : O(nlog(n-k)) // n: nums of elements in the given array, (n-k): size of PriorityQueue
  //Space Complexity : O((n-k)) // (n-k): size of PriorityQueue
  //Did this code successfully run on Leetcode : Yes
  //Any problem you faced while coding this : None
    
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder()); // with max heap
//        int val = Integer.MAX_VALUE;
//        for(int num : nums)
//        {
//            pQueue.add(num);
//            if(pQueue.size() > nums.length - k)
//                val = Math.min(pQueue.poll(), val);
//        }
//        return val;
//    }
    
    
    
    public static void main(String args[]) 
    { 
    	int[] nums = {2,3,4,1,6,5,7};
    	int k = 2;
    	Kth_Largest_Element_215 kle = new Kth_Largest_Element_215();
    	kle.findKthLargest(nums, k);
        System.out.print("" + k +"th Largest Element is: " + kle.findKthLargest(nums, k)); 
    } 
}