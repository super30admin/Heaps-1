/*
* Approach:
*  1. Create a priority queue with min heap property.
* 
*  2. Add all heads of k lists, get the min head value and append to main lists.
* 
*  3. move the head of list which is appended until it is null.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nklogk)
    n - elements in list
    k - k lists
* 
* Space Complexity: O(k)
    priority queue elements
* 
*/

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        for (int index = 0; index < lists.length; index++) {
            if (lists[index] != null)
                pq.add(lists[index]);
        }

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();

            curr.next = minNode;

            curr = curr.next;

            if(minNode.next!=null)
                pq.add(minNode.next);
        }

        return dummy.next;
    }
}
