import java.util.List;
import java.util.PriorityQueue;

/**
 * Time complexity : O(nk log k)
 * Space complexity : O(k)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedListsUsingHeap {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    public static void main(String[] args) {
        ListNode listNode1  = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2  = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3  = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;

        ListNode result = mergeKLists(lists);
        System.out.println("Merged list");
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        //base condition
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //min heap of list nodes arranged based on the value of list node
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                (a,b) -> a.val - b.val
        );

        //We add all the head nodes of all the lists into priority queue
        //The size of priority queue will be k which is numbers of lists to be merged
        for(ListNode head: lists){
            if(head != null){
                priorityQueue.add(head);
            }
        }

        while(!priorityQueue.isEmpty()){
            ListNode min = priorityQueue.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                priorityQueue.add(min.next);
            }
        }
        return dummy.next;
    }
}
