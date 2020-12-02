//Time complexity: O(m*nlog(m*n))
//Space complexity: O(m*n)
//n is the maximum number of lists and m is the maximum number of nodes in a list
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //Initialise a min heap
       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //Iterate over the list
        for(ListNode head: lists)
        {
            //as long as head not null
            while(head!=null)
            {
                //add the value at the head to min heap
                minHeap.add(head.val);
                //move to next head
                head=head.next;
            }
        }
        //Make a dummy ListNode
        ListNode dummy = new ListNode(-1);
        //make head to dummy
        ListNode head = dummy;
        while(!minHeap.isEmpty())
        {
            //adding the values to the new dummy list
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }
        //Return the dummy list which is our result
        return dummy.next;
    }
}