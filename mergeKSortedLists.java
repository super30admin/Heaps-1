//timecomplexity: O(n log (no. of lists))
//space complexity: O(no. of lists)

import java.util.*;

class Solution {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
        }
    public ListNode mergeKLists(ListNode[] lists) {
        //1. Create two pinters curr n head
        //2. Take a priority queue that sorts on ListNode values
        //3. Add first elements from all the lists 
        //4. Now keep adding the elements from minHeap to the resultant list and add elements to q if ListNode has a next element.
        //5. return head
        
        ListNode curr=null, head=null;
        if(lists==null || lists.length==0)
            return null;
        
        PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>((l1, l2)->l1.val-l2.val);
        for(int i=0; i<lists.length; i++)
        {
            if(lists[i]!=null)
                minHeap.offer(lists[i]);           
        }
        
        while(!minHeap.isEmpty())
        {
            ListNode temp=minHeap.poll();
            if(head==null)
            {
                head = new ListNode(temp.val);
                curr=head;
            }
            else
            {
                ListNode p=new ListNode(temp.val);
                p.next=null;
                curr.next=p;
                curr=p;
            }
            
            if(temp.next !=null)
            {
                minHeap.offer(temp.next);
            }
                
        }
        return head;
    }
}