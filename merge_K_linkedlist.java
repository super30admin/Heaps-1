// Time Complexity : O(nk logk) nk - total number of nodes, log k-heapify
// Space Complexity : O(log k) 
// Did this code successfully run on Leetcode : Yes
//https://leetcode.com/problems/merge-k-sorted-lists/

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
        if(lists==null || lists.length==0) return null;
        ListNode dummy=new ListNode(-1);
        ListNode result=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists)
        {
            if(head!=null)
                pq.add(head);
        }
        
        while(!pq.isEmpty())
        {
            ListNode temp=pq.poll();
            dummy.next=temp;
            if(temp.next!=null)
            {
                temp=temp.next;
                pq.add(temp);
            }
            dummy=dummy.next;
        }
        return result.next;
        
        
    }
}

//Merge two lists at a time
// Time Complexity : O(n k^2) n- average number of nodes in each list , k-number of lists
// n+2n+3n+4n+....+(k-1)n ==> nk and k in for loop
// Space Complexity : O(1) 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode result=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists) //k
        {
           dummy=merge(dummy,head); //nk
            
        }
        
        return result.next;
        
        
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode curr=new ListNode(-1);
        ListNode result=curr;
        while(l1!=null && l2!=null)
        {
            if(l1.val>l2.val)
            {
                curr.next=l2;
                l2=l2.next;
            }else
            {
                curr.next=l1;
                l1=l1.next;
            }
            curr=curr.next;
        }
        if(l1==null)
            curr.next=l2;
        else
            curr.next=l1;
        
        return result.next;
    }
}

//Brute-force
// Time Complexity : O(nk log nk) nk - total number of nodes, log k-heapify
// Space Complexity : O(log nk) 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode dummy=new ListNode(-1);
        ListNode result=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists) //k
        {
            ListNode temp=head;
            while(temp!=null)//n
            {
                pq.add(temp);//log(nk)
                temp=temp.next;
            }
            
        }
        
        while(!pq.isEmpty())
        {
            dummy.next=pq.poll();
            dummy.next.next=null;
            dummy=dummy.next;
        }
        return result.next;
        
        
    }
}