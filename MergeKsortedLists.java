import java.util.List;
import java.util.PriorityQueue;

//Time Complexity- O(nk log(k) )
//Space Complexity- O(k)

class Solution {
    public ListNode mergeKLists(List[] lists) {
        if(lists== null || lists.length==0) return null;
        
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b) -> a.val - b.val);
         ListNode dummy= new ListNode(-1);
        ListNode curr= dummy;
        
        for(ListNode head: lists){
           if(head!= null)
           { pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next= min;
           if(min.next != null) {
               pq.add(min.next);
               }
            curr= curr.next;
        }
        return dummy.next;
    }
}
