package Heaps1;

/*
 -------------------------------------------------------------------------------------------------------
 Time complexity : n*k*k
 space complexity: o(n*k) 
 Did this code run successfully in leetcode : yes
 problems faces : no
 */

public class MergeKSortedListWithLinear {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode mergedFinalList = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode node : lists)
        {
             mergedFinalList = mergeNodes(mergedFinalList, node);
        }
        
            
        return mergedFinalList.next;
    }
    
   private ListNode mergeNodes(ListNode l1,ListNode l2)
   {
       ListNode dummy = new ListNode(-1);
       ListNode current = dummy;
       
       while(l1 != null && l2 != null)
       {
           if(l1.val <= l2.val)
           {
               current.next = l1;
               l1= l1.next;
           }
           else
           {
               current.next = l2;
               l2 = l2.next;
           }
           
           current=current.next;
       }
       
       if(l1 == null) 
       {
           current.next= l2;
       }
       
       if(l2 == null) {
           current.next= l1;
       }
       
       return dummy.next;
   }

}
