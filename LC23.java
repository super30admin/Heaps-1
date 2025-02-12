// Approach 1: Using Priority Queue
// TC: O(nlogk)
// SC: O(k)

// Approach 2: Using custom MinHeap
// TC: O(nlogk)
// SC: O(k)

import java.util.*;

// Approach 1: Using Priority Queue
public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((l1, l2) -> (l1.val-l2.val));

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                minHeap.offer(lists[i]);
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode tail = ans;

        while(!minHeap.isEmpty()){
            ListNode newNode = minHeap.poll();
            tail.next = newNode;
            tail = tail.next;

            if(newNode.next!=null) minHeap.offer(newNode.next);
            tail.next = null;
        }

        return ans.next;
    }
}

// Approach 2: Using custom MinHeap
class LC23_1 {
    List<ListNode> minHeap;

    private void swap(int i, int j) {
        if (i == j)
            return;
        ListNode t = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, t);
    }

    private void downHeapify(int i, int n) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int min = i;

        if (left < n && minHeap.get(left).val < minHeap.get(min).val) {
            min = left;
        }
        if (right < n && minHeap.get(right).val < minHeap.get(min).val) {
            min = right;
        }

        if (i != min) {
            swap(min, i);
            downHeapify(min, n);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        minHeap = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        k = minHeap.size();

        for (int i = (k - 1) / 2; i >= 0; i--) {
            downHeapify(i, k);
        }

        ListNode ans = new ListNode(-1);
        ListNode tail = ans;

        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            ListNode newNode = minHeap.get(0);
            tail.next = newNode;
            tail = tail.next;

            if (newNode.next != null) {
                minHeap.set(0, newNode.next);
                downHeapify(0, minHeap.size());
            } else if (size > 1) {
                ListNode extraNode = minHeap.get(size - 1);
                minHeap.remove(size - 1);
                minHeap.set(0, extraNode);
                downHeapify(0, minHeap.size());
            } else {
                minHeap.remove(0);
            }

            tail.next = null;
        }

        return ans.next;
    }
}