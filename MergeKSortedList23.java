/** 
 * Time Complexity: insertion in heap initally O(k) + make new list O(nk) + insertion new list O(nklogk)->O(nklogk) 
 Space Complexity: O(k)
 Heap 
 * */ 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
         ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode min  = pq.poll();
            curr.next = min;
            if(min.next != null){
                 pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
        
    }
}
