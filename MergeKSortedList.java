//using max Heap
//T.C:O(NlogK) :N is total no of nodes, K is size of list
//S.C: O(K)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length == 0 ){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        for(int i=0;i<lists.length;i++){
            if(lists[i] != null ){
                pq.add(lists[i]);
            }

        }
        while(!pq.isEmpty()){
            ListNode top = pq.poll();

            if(top.next!=null){
                pq.add(top.next);
            }
            result.next=new ListNode(top.val);
            result= result.next;

        }
        return temp.next;
    }
}