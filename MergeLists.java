// Time Complexity : O(nk)
// Space Complexity : O(nk)
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
        ListNode dummy=null;
        for(int i=0;i<lists.length;i++){
             dummy=mergeList(dummy, lists[i]);
        }
        return dummy;
    }
    private ListNode mergeList(ListNode head1,ListNode head2){
        ListNode newHead=new ListNode();
        ListNode temp=newHead;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                newHead.next=head1;
                head1=head1.next;
                newHead=newHead.next;
            }else{
                newHead.next=head2;
                head2=head2.next;
                newHead=newHead.next;
            }
        }
        while(head1!=null){
            newHead.next=head1;
            newHead=newHead.next;
            head1=head1.next;
        }
        while(head2!=null){
            newHead.next=head2;
            newHead=newHead.next;
            head2=head2.next;
        }
        return temp.next;
    }
}

// Time Complexity : O(nklog(nk))
// Space Complexity : O(k)

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
        if(lists==null || lists.length==0)
            return null;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists){
            if(list!=null)
                pq.add(list);
            
        }
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            curr.next=min;
            if(min.next!=null){
                pq.add(min.next);
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}
