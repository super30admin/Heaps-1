// Time Complexity : O(n log(k))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class MergeKSortedLL {

    // Brute Force
    public ListNode mergeKListsBF(ListNode[] lists) {
        // Time: O(n log n), space: O(n)
        List<Integer> l = new LinkedList<>();
        for(ListNode ln : lists){
            while(ln != null){
                l.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(l);

        ListNode head = new ListNode(0);
        ListNode node = head;

        for(int i : l){
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = node.next;
        }

        node.next = null;
        return head.next;
    }

    public ListNode mergeKListsOptimizedSpace(ListNode[] lists) {
        // Time: O(kn), space: O(1)
        if(lists.length == 0 || lists == null){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }


    private ListNode mergeTwoLists(ListNode one, ListNode two){
        ListNode head = new ListNode(0);
        ListNode node = head;

        while(one != null && two != null){
            if(one.val < two.val){
                node.next = one;
                node = node.next;
                one = one.next;
            } else {
                node.next = two;
                node = node.next;
                two = two.next;
            }
        }

        if(one == null){
            node.next = two;
        }

        if(two == null){
            node.next = one;
        }

        return head.next;
    }

    // PQ
    public ListNode mergeKLists(ListNode[] lists) {
        // Time: O(nlog(k)), space: O(n)
        // Anonymous comapartor
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode i1, ListNode i2){
                // Ascending a-b
                return i1.val-i2.val;
                // Descending b-a
            }});

        for(ListNode l : lists){
            if(l != null){
                if(l != null){
                    pq.add(l);
                }
            }
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while(!pq.isEmpty()){
            node.next = pq.poll();
            node = node.next;

            // Remaining elements from a linked list
            if(node.next != null){
                pq.add(node.next);
            }
        }

        return head.next;
    }
}
