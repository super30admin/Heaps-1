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
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        for(ListNode listNode: lists)
        {
            dummy = mergeList(dummy.next, listNode);
        }
        
        return head.next;
    }
    
    private ListNode mergeList(ListNode headA, ListNode headB)
    {
        ListNode temp1= headA;
        ListNode temp2 = headB;
        
        ListNode dummy = new ListNode();
        ListNode head = null;

        
        while(temp1 != null || temp2 != null)
        {
            ListNode newnode = new ListNode();
            
            if(temp1 != null && temp2 != null)
            {
                if(temp1.val <= temp2.val)
                {
                    newnode.val = temp1.val;
                    temp1 = temp1.next;
                }
                else
                {
                    newnode.val = temp2.val;
                    temp2 = temp2.next;                 
                }
            }
            else if(temp1 != null)
            {
                    newnode.val = temp1.val;
                    temp1 = temp1.next;
            }
            else
            {
                    newnode.val = temp2.val;
                    temp2 = temp2.next;                  
            }
            
            newnode.next = head;
            head= newnode;
        }
        
        return head;
    }
}