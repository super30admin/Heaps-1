package s30.Heaps-1;

public class problem2 {
     class Solution {
        //TC:- O(n)
        //SC:- O(n)
        public ListNode mergeKLists(ListNode[] lists) {
            return mL(lists, 0, lists.length - 1);
        }
        
        private ListNode mL(ListNode[] lists, int l, int r) {
            if (r < l) return null;
            if (r == l) return lists[r];
            
            int mid = (l + r) / 2;
            ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
            ListNode dmHead = new ListNode(0), cur = dmHead;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    cur.next = a;
                    a = a.next;
                } else {
                    cur.next = b;
                    b = b.next;
                }
                cur = cur.next;
            }
            cur.next = (a != null) ? a : b;
            
            return dmHead.next;
        }
    }
}
