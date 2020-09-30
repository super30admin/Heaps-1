    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/merge-k-sorted-lists/
    Time Complexity for operators : o(nlogk) ..
    Extra Space Complexity for operators : o(n*logk) ... 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach:
                              
            Approach :- 
                    A. Create a minheap of an element.
                    B. During insert itself check for the size of heap is greate than k or not
                    C. If it is greater that means we reached and need to remove  the  top element.
                    D. AFter each insert and remove, You will get the top element on the top of an heap.\
       */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
    }
}