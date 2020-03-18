// Time Complexity : For creating a minheap object complexity will be log n. 
// k log k+(n-k) log k = n log k
 // For creation of minheap of size k is k log n
 // For n-k elements added to minheap is n-k log n
// Space Complexity : o(k) to store elements in heap 
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0 || nums==null)return 0;
        
        PriorityQueue<Integer> mp=new PriorityQueue<>();
        for(int j=0;j<k;j++){
            mp.add(nums[j]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i] >mp.peek()){
                mp.poll();
                mp.add(nums[i]);
            }
        }
        return mp.peek();
    }
}