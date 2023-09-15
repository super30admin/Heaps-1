//import java.util.List;

import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        MergekSortedLists obj = new MergekSortedLists();
        ListNode obj1 = obj.mergeSortedList(lists);
        System.out.println(obj1);
        while (obj1!= null){
            System.out.println(obj1.val);
            obj1 = obj1.next;
        }

    }

    public ListNode mergeSortedList(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((a, b) -> (a.val - b.val)));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }

        }

        return dummy.next;

    }

    static class ListNode {

        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;

        }

    }
}