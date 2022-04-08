import java.util.PriorityQueue;
//Time Complexity O(N*M)
//Space Complexity O(N)
//LeetCode Tested
public class MergeKSortedLists {
    class Pair implements Comparable<Pair>{
        int li;
        ListNode lNode;
        int val;
        Pair(int li,ListNode lNode,int val){
            this.li = li;
            this.lNode = lNode;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode tail = null;
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            Pair p = new Pair(i,current,current.val);
            pq.add(p);
        }
        while (pq.size() > 0){
            Pair p = pq.remove();
            if(result == null){
                result = p.lNode;
                tail = result;
            }else{
                ListNode currentNode = p.lNode;
                tail.next = currentNode;
                tail = tail.next;
            }
            ListNode head = lists[p.li];
            head = head.next;
            if(head!=null){
                p.val = head.val;
                p.lNode = head;
                pq.add(p);
            }
        }
        return result;
    }
}
