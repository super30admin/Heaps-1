class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode();

        Queue<ListNode> q = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

        for(ListNode temp : lists){
            if(temp != null) q.add(temp);
        }

        ListNode temp = dummy;

        while(!q.isEmpty()){

            ListNode curr = q.poll();
            ListNode next = curr.next;

            temp.next = curr;
            curr.next = null;
            temp = temp.next;

            if(next != null){
                q.add(next);
            }
        }

        return dummy.next;

    }
}
