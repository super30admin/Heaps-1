public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode li = new ListNode(-1);
        ListNode head = li;
        List<Integer> l = new ArrayList<>();

        for (ListNode list : lists) {
            while(list != null) {
                l.add(list.val);
                list = list.next;

            }
        }

        Collections.sort(l);
        for (int i=0; i < l.size(); i++){

            li.next = new ListNode(l.get(i));
            li = li.next;
        }
        
        return head.next;
    }
}