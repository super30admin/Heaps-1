import java.util.PriorityQueue;

public class MergeKSorted {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    //Time complexity: O(NLogK)
    //Space complexity NK
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) ->{ return a.val - b.val;});

        for(int i = 0 ; i< lists.length; i++){
            ListNode current = lists[i];
            while(current != null){
                queue.offer(current);
                current = current.next;
            }
        }
        ListNode head = queue.poll();
        ListNode current = head;
        while(!queue.isEmpty()){
            current.next = queue.peek();
            current = queue.poll();
            current.next = null;
        }


        return head;

    }
}
