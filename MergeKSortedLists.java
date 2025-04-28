//Time: O(Nlogk) , N = total no of elements in all the lists
//Space: O(k), size of heap 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*Approach:
1. Insert the heads of all the lists in a minHeap such that the minimum of all the node values is on top
2. Pop the min val node from heap and add its next node if present to the heap
3. Keep popping the min node and adding its next until the heap is empty
3. Create a dummy list to store all the min value nodes popped from heap
4. return the dummy node head as the result
*/
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr=dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val); //Min heap sorted on the basis of Listnode values

        if(lists.length==0)
            return null;

        for(ListNode l:lists){

            if(l!=null)
                pq.add(l);
        }

        while(!pq.isEmpty()){

            ListNode temp=pq.poll();
            curr.next=temp;
            curr=curr.next;

            if(temp.next!=null){
                pq.add(temp.next);
            }

        }
        return dummy.next;
    }
}