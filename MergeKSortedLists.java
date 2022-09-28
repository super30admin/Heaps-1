// Time Complexity :O(nk log k)
// Space Complexity : O(k)
//n is the number of elements in each list
//k is the number rof lists
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 1 - Using MinHeap
//TC: O( nk log k)
//SC: O(k)
//n is the number of elements in each list
//k is the number rof lists
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head != null) {
                pq.add(head);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}

//Method 2 - Brute Force , Merge 2 lists and continue doing the same for all the lists given
//TC: O(nk^2)
//SC: O(nk)
//n is the number of elements in each list
//k is the number of lists
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
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li: lists){
            if(li != null){
                merged = merge(merged,li);
            }
        }
        return merged.next;
    }

    private ListNode merge(ListNode head1 , ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if(head1 != null){
            curr.next = head1;
        }

        if(head2 != null){
            curr.next = head2;
        }
        return dummy.next;
    }
}