// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//215. Kth Largest Element in an Array
//https://leetcode.com/problems/kth-largest-element-in-an-array/


public class Problem1 {
    //Using MAX HEAP
    //time: O(nlog(n-k))
    //space: O(n-k)
    int N = 0;
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        int var = 100001;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int n: nums){
            pq.add(n);
            if(pq.size() > N-k){
                int temp = pq.poll();
                if(var>temp)
                    var = temp;
            }
        }
        return var;
    }
}



/*
class Solution {
    //Using MIN HEAP
    //time: O(nlogk)
    //space: O(k)
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll(); //System.out.println("after else " + pq.peek());
            } 
        }
        
        return pq.peek(); 
    }
}
*/
