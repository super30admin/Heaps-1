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
 //brute force- take all nodes in an array, sort it convert it to linkedlist - TC- O(NlogN)- nklognk


 //heap solution
 //tc- O(nk log k)
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));

        for(ListNode list : lists){//putting  k headnodes in pq
            if(list != null){
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){//while pq is not empty
            ListNode currMin = pq.poll();//take top min node
            curr.next = currMin;//put it to curr next
            curr = curr.next;//move curr to next node to make it ready for next node
            if(currMin.next!=null){//put next node into pq from k list of currMin
                pq.add(currMin.next);
            }

        }
        return dummy.next;
        
    }
}