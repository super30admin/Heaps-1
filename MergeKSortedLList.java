/**
  Time : O(nlog(m))  n = all the Node, m = number of lists.
  Space: O(1) since we ll only store m number of nodes in pq at any time.
  Run in LeetCode : Yes
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode(-1);
        if(lists.length == 0)
            return ret.next;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });

        for(ListNode node: lists){
            if(node != null)
                pq.offer(node);
        }
        ListNode cur = ret;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            if(node.next != null){
                ListNode nextNode = node.next;
                pq.offer(nextNode);
            }
            cur = node;
        }
        return ret.next;
    }
}
