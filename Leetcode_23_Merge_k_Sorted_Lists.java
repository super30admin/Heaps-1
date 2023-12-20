/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * approach
 * 
 * BF : add all nodes to array, sort array and return oth as head,
 * tc :O(LK) + log (LK)
 * sc: O(LK)
 * l = avg len of linkedlist, k = total linkedlist
 * 
 * 
 * approach -2
 * priority Queue - Min Heap
 * insert, head of the list in PQ, and move to next, and keep on doing it, until
 * we exhaust all lists.
 * 
 * then start extracting elements from PQ until emplty, which creates result.
 * 
 * TC: O(LK log LK)
 * 
 * approach -3
 * just add 3 heads in for loop, and to the heap.
 * while extracting, we'll keep adding extractedNode's next to PQ.
 * 
 * same PQ approach, but maintain the heap for k size only.
 * Actually we dont need to maintain size here with k, automatically when one
 * node leaves, it's next will be added, and at last when q is empty that means
 * we got all the elements out!
 * 
 * TC: O(LK log K)
 * sc: O(log k)
 * 
 * 
 * approach - merged Lists!
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list);
                System.out.println("Val - " + list.val);
                list = list.next;
            }
        }

        while (!pq.isEmpty()) {
            ListNode ext = pq.poll();
            dummy.next = ext;
            dummy = ext;
        }
        dummy.next = null;
        return curr.next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
            // System.out.println("Val - "+list.val);
            // list = list.next;
        }

        while (!pq.isEmpty()) {
            ListNode ext = pq.poll();
            dummy.next = ext;
            dummy = ext;

            if (ext.next != null) {
                pq.add(ext.next);
            }
        }
        // dummy.next = null;
        return curr.next;
    }
}

/// Merging Lists Approach TC: n^2 k ; erging listsmakes it of n, 2n, 3n, 4n , .
/// . n*n , and we do this for K lists! n is elements/nodes
// sc: O(1) - not using any intermediate space!

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null)
            return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode merged = dummy;

        for (ListNode list : lists) {
            merged = mergeHelper(merged, list);
        }
        return dummy.next;
    }

    private ListNode mergeHelper(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }
}