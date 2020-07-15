// Time Complexity - O(n*(k^2)) n = no of elements in a single list, k = no of lists
// Space Complexity - O(1)


// Brute Force - Merge two lists at a time continuously
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;

        for(ListNode curList: lists){
            dummy = merge(dummy, curList);
        }

        return result.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){

        ListNode cur = new ListNode(-1);
        ListNode result = cur;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null){
            cur.next = l1;
        }
        return result.next;
    }
}


// Time Complexity - O(nklogk) n = no of elements in a single list k = no of lists
// Space Complexity - O(k) size of priority queue having k heads of the lists

 // Maintain a min heap so that it always aintains k max elements at a particular point of time and 
 // releases min element in those k elements in O(1) time. Push the head of all lists into minheap.
 // Extract the minNode and move the pointer forward in that corresponding list.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head:lists) {
            if(head!=null) pq.add(head);
        }
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next!=null) {
                min = min.next;
                pq.add(min);
            }
        }
        return result.next;
    }
}