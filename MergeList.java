//TC: nk(logk) n-> length of each list, k-> num of lists , log k -> for heapify
//SC: k 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        if(lists == null || lists.length == 0)
            return null;
        
        //add head of each list
        for(ListNode head : lists){
            if(head != null)
                pq.add(head);
        }
        
        //create a dummy node
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while(!pq.isEmpty()){
            // remove smallest element from top of the queue
            ListNode tmp = pq.poll();

            //add next element
            if(tmp.next != null)
                pq.add(tmp.next);
            
            cur.next = tmp;
            cur = cur.next;
           
        }
        
        return dummy.next;
        
    }
}