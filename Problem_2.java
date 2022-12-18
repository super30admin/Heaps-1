// Time Complexity : O(nklogk) --for k sorted lists
// Space Complexity :O(k) --in case of min heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//using minHeap

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        
        PriorityQueue<ListNode> minH = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null) {
                minH.add(list);
            }
        }
        while(!minH.isEmpty()){
            ListNode a = minH.poll();
            if(a.next != null){
                minH.add(a.next);
            }
            dummy.next = a;
            dummy = dummy.next;
        }
        return head.next;
    }
}