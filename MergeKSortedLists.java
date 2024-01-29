//T.C O(n log k)//k is no. of lists
//S.C O(k)//heap size
//Executed in Leetcode: yes
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

/*
Use priority queue to concat all the lists. The PQ will take care of sorting too.
Traverse through the queue till end and add links between each list.
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode resHead = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head: lists){
            if(head!=null)
                pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            if(temp.next != null)
                pq.add(temp.next);
            res.next = temp;
            res = res.next;
        }

        return resHead.next;

    }
}