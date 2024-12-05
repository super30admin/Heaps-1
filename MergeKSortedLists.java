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
// Approach : merging two lists and then merge with remaining list
// Time : O (NK) = O(nk*k) = O(nk^2) // Total K lists with average length of n for each list and then we still need to merge.
// Space : O(n)    
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = null;
        for(ListNode li:lists){
            merged = merge(merged,li);
        }
        return merged;
    }
    // Merge two Linked Lists
    public ListNode merge(ListNode a , ListNode b){
        ListNode curr = new ListNode(-1); // dummy node
        ListNode result = curr; // initialize merged list
        while(a!=null && b!=null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            } else{
                curr.next =b;
                b=b.next;
            }
            curr = curr.next;
        }
        if(a!=null){
            curr.next = a; 
        }

        if (b!=null){
            curr.next = b;
        }
        return result.next;
    }
}

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
// Approach : using Min Heap
// Time :O(nklogk) 
// Space : O(K)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val)); // default -min heap
        // Add all the heads of list nodes to pq - because they are all sorted
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1); // dummy node
        ListNode result = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll(); // gives the min of heads
            dummy.next = min;
            dummy = dummy.next;
            if(min.next!=null){
                pq.add(min.next);
            } 
        }
        return result.next;
    }
}