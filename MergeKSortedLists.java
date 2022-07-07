//Time Complexity=O(Nlogk)
//Space Compleity=O(K)
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);

        for(ListNode head:lists){
            if(head!=null){

                pq.add(head);
            }
        }
        ListNode result=new ListNode(-1);
        ListNode curr=result;
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            curr.next=min;
            curr=curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return result.next;

    }
}
