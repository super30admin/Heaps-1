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

    public ListNode getSampleNode() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node;
    }

    public ListNode[] getSameNodeList() {
         //[[1,4,5],[1,3,4],[2,6]]
         ListNode one = new ListNode(1);
         ListNode node4 = new ListNode(4);
         ListNode node5 = new ListNode(5);
         one.next = node4;
         node4.next = node5;
 
         ListNode two = new ListNode(1);
         ListNode node3 = new ListNode(3);
         ListNode node42 = new ListNode(4);
         two.next = node3;
         node3.next = node42;
 
         ListNode three = new ListNode(2);
         ListNode node6 = new ListNode(6);
         three.next = node6;
         ListNode[] lists = new ListNode[]{one, two, three};
         return lists;
    }
}