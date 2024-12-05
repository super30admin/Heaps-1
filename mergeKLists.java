import java.util.PriorityQueue;

public class mergeKLists {
    //min heap approach
    public ListNode mergeKLists(ListNode[] lists) {

        //merge 2 lists at a time approach 
        // ListNode merged = new ListNode();
        // for(ListNode l: lists){
        //     merged = merge(l, merged);
        // }
        // return merged.next;


        //min heap approach
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode();
        ListNode curr = head;
        for(ListNode l: lists){
            if(l != null)
                pq.add(l);  //we are adding the heads of the list 
        }
        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if(currMin.next != null){
                //we are adding the next head from the one that we just removed. 
                pq.add(currMin.next);
            }
        }
        return head.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return dummy.next;
    }

}
