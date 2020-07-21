class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp = lists[i];
            while(temp!=null){
                pq.add(temp.val);
                temp=temp.next;
            }
        }
        
        int s = pq.size();
        System.out.println(s);
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for(int i=0;i<s;i++){
            head.next = new ListNode(pq.remove());
            head = head.next;
        }
        return dummy.next;
    }
}