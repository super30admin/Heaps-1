import java.util.PriorityQueue;
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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // // a. using heap
        // PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val - b.val));
        // // add all first nodes of k lists
        // for(ListNode head : lists)
        // {
        //     if(head != null)
        //     {
        //         minHeap.add(head);
        //     }
        // }
        // // remove min node - root of min heap - add to result L.L
        // // move pointer of polled min node and add new node to min heap
        // ListNode dummyForResult = new ListNode(-1);
        // ListNode curr = dummyForResult;
        // while(!minHeap.isEmpty())
        // {
        //     ListNode minNode = minHeap.poll();
        //     curr.next = minNode;
        //     curr = curr.next;
        //     if(null != minNode.next)
        //     {
        //         minHeap.add(minNode.next);
        //     }
        // }
        // return dummyForResult.next;

        // b. merge first two L.L of k L.L and merge the resultant L.L with the next L.L of k lists
        ListNode dummyForResult = new ListNode(Integer.MIN_VALUE); 
        // we are using dummy node as actual node while merging so we need to have in min as val for dummy node and not -1
        // -infinity, 1, 1, 2, 3, 4, 4, 5, 6 and send dummy.next as result head node
        for(ListNode head : lists)
        {
            if(null != head)
            {
                dummyForResult = merge(dummyForResult, head);
            }
        }
        return dummyForResult.next;
    }

    private ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode dummyForMerge = new ListNode(-1);
        ListNode resultPointer = dummyForMerge;
        ListNode p1 = list1, p2 = list2;
        while(p1 != null && p2 != null)
        {
            if(p1.val < p2.val)
            {
                resultPointer.next = p1;
                p1 = p1.next;
            }
            else
            {
                resultPointer.next = p2;
                p2 = p2.next;
            }
            resultPointer = resultPointer.next;
        }
        if(p1 == null)
        {
            resultPointer.next = p2;
        }
        if(p2 == null)
        {
            resultPointer.next = p1;
        }
        return dummyForMerge.next;
    }
}