// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Method used : Min heap

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        for(ListNode list : lists)
        {
            if(list != null) heap.add(list);
        }
            
        
        while(!heap.isEmpty())
        {
            ListNode node = heap.poll();

            if(node.next != null) heap.add(node.next);
            
            temp.next = node;
            temp = temp.next;
        }

        return result.next;
    }
}