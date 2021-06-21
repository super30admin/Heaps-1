//Time Complexity : O(Nlogk). here N=nk,total number of elements
//Space Complexity : O(k). At max, the heap will store atmost k elements
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        //initially add the head of all the k lists to heap i,e the min elements
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        while(!pq.isEmpty()){
            //pop the min
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = min;
            //choose the next element from the list that min was extracted
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}