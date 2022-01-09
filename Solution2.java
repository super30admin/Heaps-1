import java.util.PriorityQueue;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach-Brute force
//merge n lists by taking two at a time
// n be the total number of lists and k be the average kength of each list
// Time Complexity : O(nk*n)(nk comparisons carried out n times)
// Space Complexity :O(1) no extra space required

class Solution {
//Definition for singly-linked list.
  public class ListNode {
    int val;
   ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        ListNode head=null;
        for(ListNode list:lists){
             head=merge(head,list);
        }
        return head;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
       
        ListNode head=new ListNode(-1);
        ListNode dummy=head;
        while(l1!=null && l2!=null){
            
            if(l1.val<l2.val){
                dummy.next=l1;
                l1=l1.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        
        if(l1!=null)
            dummy.next=l1;
        if(l2!=null)
            dummy.next=l2;
        
        return head.next;
    }


    //Priorty queue solution
    // added the head first and extrating minim one at a time to add it to the resultant list
    // adding the next node of the extracted node if its not null

    // Time Complexity : O(nklogn)( k being the average length of each lists and n being teh total number of lists, all nodes touched once)
// Space Complexity :O(n) maximum of n elements in the priority queue
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode head=new ListNode(-1);
        ListNode dummy=head;
        for(ListNode list:lists){
             if(list!=null)
                 pq.add(list);
        }
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            dummy.next=min;
            if(min.next!=null){
                pq.add(min.next);
            }
            dummy=dummy.next;
        }
        return head.next;
    }
}