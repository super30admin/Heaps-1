// Time Complexity :O(N log(k)) N = no of nodes in heap and K = no of lementd to heapify
// Space Complexity : O(K)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Maintaining a MinHeap and removing the top element and heapifying if necessary. 
// Adding the next elements of the list and comparing them would give us a sorted list.

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode get(ListNode res) {
        return res.next;
    }

}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(new pComp());

        for (ListNode list : lists) {
            if (list != null)
                p.add(list);

        }

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (!p.isEmpty()) {
            ListNode top = p.poll();
            if (top.next != null) {
                p.add(top.next);
            }
            curr.next = top;
            curr = curr.next;
        }

        return head.next;

    }

    public static void main(String args[]) {
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list1.next = new ListNode(6);

        ListNode[] lists = { list1, list2, list3 };
        ListNode res = obj.mergeKLists(lists);
        obj.printList(res);

    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}

class pComp implements Comparator<ListNode> {
    public int compare(ListNode s1, ListNode s2) {
        if (s1.val < s2.val)
            return -1;
        else if (s1.val > s2.val)
            return 1;

        return 0;
    }

}