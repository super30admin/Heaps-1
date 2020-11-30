package S30.Heaps_1;

/*Heap Solution
Time Complexity : O(NlogK), K is number of lists, N is max size of list
Space Complexity : O(K)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/* 2 pointer merging solution
Time Complexity : O(N(K^2)), K is number of lists, N is max size of list
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //Heap Solution
    public ListNode mergeKListsHeap(ListNode[] lists) {


        ListNode result = new ListNode(-1);

        if(lists.length == 0) return null;
        ListNode temp = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){

            @Override
            public int compare(ListNode e1, ListNode e2){
                return e1.val - e2.val;
            }

        });

        for(int i = 0; i < lists.length; i++){

            if(lists[i] != null)
                minHeap.offer(lists[i]);
        }

        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            if(curr.next != null){
                minHeap.offer(curr.next);
            }
            temp.next = new ListNode(curr.val);
            temp = temp.next;
        }
        return result.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        for(ListNode head : lists){
            newHead = mergeTwoLists(head,newHead);
        }
        return newHead.next;

    }

    //Merging 2 lists at a time
    private ListNode mergeTwoLists(ListNode head1, ListNode head2){

        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode buildingPtr = dummy;

        while(curr1 != null && curr2 != null){

            if(curr1.val < curr2.val){
                ListNode nextNode = new ListNode(curr1.val);
                buildingPtr.next = nextNode;
                curr1 = curr1.next;

            }else{
                ListNode nextNode = new ListNode(curr2.val);
                buildingPtr.next = nextNode;
                curr2 = curr2.next;
            }
            buildingPtr = buildingPtr.next;

        }
        if(curr1 == null) buildingPtr.next = curr2;
        else buildingPtr.next = curr1;

        return dummy.next;
    }
}
