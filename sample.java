class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();

    }
}

//
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode listhead : lists) {

            if (listhead != null) {
                pq.add(listhead);
            }
        }

        ListNode dummyhead = new ListNode(0);
        ListNode tail = dummyhead;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;
            // Add the next node of the smallest to the priority queue
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummyhead.next;
    }
}
