//Time Complexity   O(nk) where n is the average length of a list, k number of lists
//Space Complexity   O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode result = merged;
        
        for(ListNode node : lists){
            merged = mergeLists(merged,node);
        }
        return result.next;
    }
    private ListNode mergeLists(ListNode node1,ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(node1!= null && node2 != null){
            if(node1.val < node2.val){
                dummy.next =node1;
                node1 = node1.next;
                
            }
            else{
                dummy.next =node2;
                node2 = node2.next;
                
            }
            
            dummy = dummy.next;
        }
        if(node1!=null){
            dummy.next = node1;
        }
        if(node2!=null){
            dummy.next = node2;
        }
        return result.next;
    }
}








//With Heap
//Time complexity O(n log k) k is the number of lists, n is the average nodes in each list
//Space Complexity O(k) k - number of lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val -b.val);
        
        for(ListNode head : lists){
            if(head!=null)
                pq.add(head);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next!=null)
                pq.add(min.next);
  
        }
        
        return result.next;
    }
}
