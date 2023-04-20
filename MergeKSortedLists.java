/**
 * Time Complexity -  O(N logk) where N is the num. of nodes in each of the list in Lists. K is the number of list in lists
 * Space Complexity - O(k)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for(ListNode list : lists)
            if(list != null)
                pq.add(list);
        
        ListNode head = new ListNode(0), copy = head;

        while(!pq.isEmpty()){
            copy.next = pq.poll();
            copy = copy.next;
            ListNode temp = copy.next;
            if(temp != null)
                pq.add(temp);
        }
        return head.next;
    }
}
