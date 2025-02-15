public class Problem2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length==0){
                return null;
            }
            ListNode dummy = new ListNode(-1);
            //create a priority queu on basis of val of ListNode
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
            for(ListNode node : lists){
                //add the first node of each ll
                if(node != null){
                    pq.add(node);
                }
            }
            ListNode curr = dummy;
            while(!pq.isEmpty()){
                //poll queue which will provide the min at that time and move the pointer of that ll to next and add that node to pq
                ListNode currMin = pq.poll();
                curr.next = currMin;
                if(currMin.next != null){
                    pq.add(currMin.next);
                }
                curr = curr.next;
            }
            return dummy.next;
        }
    }
}
