//solved successfully on leetcode n faced no issues
//tc : O(Nlogk) sc:O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>heap = new PriorityQueue<>((a,b)->a.val-b.val);   //if a-b is negative a is smaller we will put a forward (swap happens internally) , if a-b is positive b is smaller , we will keep b forward
        
        ListNode dummynode = new ListNode(-1);
        ListNode curr = dummynode;

        //adding head of each list into minheap
        for(ListNode head : lists){
            if(head!=null){
                heap.add(head);
            }
        }

        //process the heap 
        while(!heap.isEmpty()){
            //take out the smallest node from heap 
            ListNode min = heap.poll();
            //and add it to the merged result(curr)
            curr.next = min;
            //if the removed smallest node has next , move to next pointer
            if(min.next!=null){
                heap.add(min.next);
            }
            //if you don’t move curr forward, next time you do curr.next = ..., you’ll overwrite the same next pointer instead of adding after the newly added node.
            curr = curr.next;

        }
        return dummynode.next;
        
    }
}