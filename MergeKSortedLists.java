
public class MergeKSortedLists {
    public class ListNode {
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

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    ListNode result = dummy;
    java.util.PriorityQueue<ListNode> pq = new java.util.PriorityQueue<>((a, b) -> a.val - b.val);for(
    ListNode node:lists)
    {
        if (node != null) {
            pq.add(node);
        }

    }while(!pq.isEmpty())
    {
        ListNode current = pq.poll();
        result.next = current;
        if (current.next != null) {
            pq.add(current.next);
        }
        result = result.next;
    }return dummy.next;
}}
