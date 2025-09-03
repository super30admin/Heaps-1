//approach-we initially put heads os all lists in a min heap, we are taking advantage of the fact that each list is sorted, we pop() the heap to the min value node then add the next node if availabile.we are getting nodes in ascending order of their values.
//time complexity-O(n*logk) n=total no. of nodes in all list together, k= no.of lists, for each node we are performing heapify on k sized heap which would take logk;
//space complexity-O(k) k being the space for the heap i.e at each point there will be a k no.of nodes inside.
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
        PriorityQueue<ListNode> p=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l : lists){
            if(l!=null)p.add(l);
        }
        ListNode dummy= new ListNode(-1);
        ListNode cur=dummy;
        while(!p.isEmpty()){
            ListNode node=p.poll();
            cur.next=node;
            cur=cur.next;
            if(node.next!=null)p.add(node.next);
        }
        return dummy.next;

    }
}
