
// Time - O(nk log k)
// Space - O(n)



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {


        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        // add the listnodes to the queue
        for(ListNode head : lists) {

            if(head != null) {

                pq.add(head);
            }

        }


        ListNode dummy = new ListNode(-1); // create dummy listnode to store result
        ListNode curr = dummy;

        while(!pq.isEmpty()) {

            ListNode min = pq.poll(); // remove the minimum
            curr.next = min; // refer to the address of the min
            curr = curr.next; // move the curr pointer to the min address

            if(min.next != null) { // if the min has next element add it to the queue

                pq.add(min.next);


            }


        }

        return dummy.next; // return the result listnode list


    }
}