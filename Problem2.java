/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Method 1:
    //Time Complexity: O(Nlogk) - k is the number of lists and N - Total number of elements in list
    //Space Complexity: O(N) - N - Total number of elements in List
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists) {
            while(node != null) {
                pq.add(node);
                node = node.next;
            }
        }
    
    ListNode dummy = new ListNode(-1);
    ListNode res = dummy;
    while(!pq.isEmpty()) 
    {
        ListNode curr = pq.poll();
        dummy.next = curr;
        dummy = dummy.next;
    }
    dummy.next = null;
    return res.next;
    }
    
    Method 2:
    //Time Complexity: O(Nlogk) - k is the number of lists and N - Total number of elements in list
    //Space Complexity: O(k) - k - the number of lists
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists) {
            if(node != null) {
                pq.add(node);
            }
        }
    
    ListNode dummy = new ListNode(-1);
    ListNode res = dummy;
    while(!pq.isEmpty()) 
    {
        ListNode curr = pq.poll();
        dummy.next = curr;
        dummy = dummy.next;
        if(curr.next != null) {
            pq.add(curr.next);
        }
    }
    dummy.next = null;
    return res.next;
    }
    */
    //Method 3:
    //Time Complexity : O(Nk^2) k is the number of lists and N - Total number of elements in list
    //Space Complexity: O(N) - N - Total number of elements in list
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode dummy1 = new ListNode(Integer.MIN_VALUE);
        ListNode res1 = dummy1;
        for(ListNode list: lists) {
            if(list != null)
                dummy1 = merge(dummy1,list);
            
        }
        return res1.next;
    }
    
    
    private ListNode merge(ListNode l1,ListNode l2) {
        ListNode l11 = l1;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null)
            dummy.next = l1;
        if(l2 != null)
            dummy.next = l2;
        return res.next;
        
    }
}
