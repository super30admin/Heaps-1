// Time Complexity - O(total nodes * log(number of lists))
// Space Complexity - O(number of lists)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < lists.length ; i++){
            if(lists[i] != null){
                heap.add(lists[i]);
            }
        }
        ListNode curr = dummy;
        while(heap.size() > 0){
            ListNode node = heap.poll();
            if(node.next != null){
                heap.add(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
