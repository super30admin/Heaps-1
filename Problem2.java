// Time Complexity : O(klogk + kl logk), where l is the length of the longest list
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val  - b.val); // min heap
        for(int i=0;i<lists.length; i++){ // Oklogk
            if(lists[i]!=null)
            queue.add(lists[i]); // Adding the heads of the lists O(log k)
        }

        if(!queue.isEmpty()){
            head = queue.remove();
            if(head.next!=null){
                queue.add(head.next);
            }
            ListNode prev = head;
            while(!queue.isEmpty()){ // let l be the length of longest list  O (kl log k )
                ListNode current = queue.remove(); // we will keep max of k items in the queue as we are keep on removing it
                prev.next = current;
                if(current.next!=null){
                queue.add(current.next); // logk
                }
                prev = current;
            }
        }

        return head;
        
    }
}
