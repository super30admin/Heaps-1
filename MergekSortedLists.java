
//Time Complexity : O(Nk)
//Space Complexity : O(k) for heap
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


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
 /*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null)
                pq.add(l);
        }
        ListNode head = new ListNode();
        ListNode curr=head;
        while(!pq.isEmpty()){
            ListNode top=pq.poll();
            curr.next=top;
            curr=curr.next;
            if(top.next!=null){
                pq.add(top.next);
            }
        }
        return head.next;
    }
}
*/
class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode merged=lists[0];
        for(int i=1;i<lists.length;i++){
            merged=merge(merged,lists[i]);
        }
        return merged;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null){
            head.next=l1;
        }
        if(l2!=null){
            head.next=l2;
        }

        return dummy.next;
    }
}
