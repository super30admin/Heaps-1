import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


public class MergeKSortedLists {
/**
 * Time Complexity : O(nk log k) where n is number of nodes in a linked lists and k is number of linked lists
 *  Space Complexity : O(k)
 */
    //Using Priority Queue
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0){return null;}
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);           
        for(ListNode node: lists){
            if(node != null)            
                pq.add(node);                                                               
        }
        while(!pq.isEmpty()){                                                               
            ListNode min = pq.poll();                                                       
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null)                                
                pq.add(min.next);                                                       
        }
        return result.next;
    }


    /**
     * Time Complexity : O(nk^2) where n is number of nodes in a linked lists and k is number of linked lists
     *  Space Complexity : O(1)
     */

    //Using Merging Method
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){return null;}
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        for(ListNode node : lists){
            dummy = merge(dummy, node);                                                     
        }
        return result.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){return l2;}
        if(l2 ==  null){return l1;}
        ListNode curr = new ListNode(Integer.MIN_VALUE);                                        
        ListNode head = curr;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){                                                            
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;                             
                l2 = l2.next;
            }
            curr = curr.next;                                                             
        }
        if(l1 == null) {
            curr.next = l2;                                                             
        }
        if(l2 == null){
            curr.next = l1;                                                            
        }
        return head.next;                                                     
    }
}
