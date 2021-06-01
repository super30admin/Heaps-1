class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        if(lists == null)
        {
            return null;
        }
        for(ListNode head : lists)
        {
            if(head != null)
            {
                heap.add(head);
            }
        }
        while(!heap.isEmpty())
        {
            ListNode minimum = heap.remove();
            dummy.next = minimum;
            dummy = dummy.next;
            if(minimum.next !=null)
            {
                heap.add(minimum.next);
            }
        }
        return temp.next;
    }
}
