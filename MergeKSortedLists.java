import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // return collectAllValuesAndSort(lists);
        // return compareAllListsAndMerge(lists);
        // return divideAndConquer(lists, 0, lists.length - 1);
        return mergeKListsUsingMinHeap(lists);
    }

    // TC: O(NlogK) where N is number of nodes and K is length of lists
    // SC: O(K) where K is length of lists
    private ListNode mergeKListsUsingMinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) minHeap.add(l);
        }
        ListNode res = new ListNode();
        ListNode curr = res;
        while (minHeap.size() > 0) {
            ListNode top = minHeap.poll();
            curr.next = new ListNode(top.val);
            curr = curr.next;
            if (top.next != null) minHeap.add(top.next);
        }
        return res.next;
    }

    // TC: O(NlogK) where N is number of nodes and K is length of lists
    // SC: O(K) where K is length of lists
    private ListNode divideAndConquer(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode first = divideAndConquer(lists, left, mid);
        ListNode second = divideAndConquer(lists, mid + 1, right);
        return mergeTwoLists(first, second);
    }

    // TC: O(M + N) where M is number of nodes in p and N is number of nodes in q
    // SC: O(1)
    private ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode merged = new ListNode();
        ListNode curr = merged;
        while (p != null && q != null) {
            if (p.val < q.val) {
                curr.next = new ListNode(p.val);
                p = p.next;
            } else {
                curr.next = new ListNode(q.val);
                q = q.next;
            }
            curr = curr.next;
        }
        if (p != null) curr.next = p;
        if (q != null) curr.next = q;
        return merged.next;
    }


    // TC: O(NlogN) where N is number of nodes in all the lists
    // SC: O(N) where N is number of nodes in all the lists
    private ListNode collectAllValuesAndSort(ListNode[] lists) {
        List<Integer> vals = new ArrayList<>();
        for (ListNode l : lists) {
            while (l != null) {
                vals.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(vals);
        ListNode res = new ListNode();
        ListNode curr = res;
        for (int i = 0; i < vals.size(); i++) {
            curr.next = new ListNode(vals.get(i));
            curr = curr.next;
        }
        return res.next;
    }
}
