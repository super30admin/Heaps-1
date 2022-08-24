//TC - O(nklogk)
//SC - O(k)
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode head=new ListNode();
        ListNode dummy = head;
        int k = lists.length;
        
        if(lists.length==0) return null;
        
        for(int i=0;i<k;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode el =  pq.poll();
            //ListNode newNode = el;
            dummy.next = el;
            dummy = dummy.next;
            
            if(el.next!=null){
                pq.add(el.next);
            }
        }
        
        return head.next;
        
        
    }
}

/// without priority queue

/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;
        
        if(lists.length==0) return null;
        ListNode merged = lists[0];
        for(int i=1;i<k;i++){
            merged = merge(merged,lists[i]);
        }
        
        return merged;
   
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode dummy = head;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next=l1;
                l1=la1.next;
                dummy=dummy.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
                dummy=dummy.next;
            }            
        }
        
        if(l1!=null){
                dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        

        
        return head.next;
        
    }
}
*/