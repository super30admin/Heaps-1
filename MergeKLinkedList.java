// Time Complexity : O(NkLogNK) where N is total number of lists and k is avg length of list
// Space Complexity: O(Nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use priority Queue, in step 1, put all the head nodes into the PQ (here it is min heap)
loop through priority queue, poll the elements in pq, add them to new head (form a new LL)
then add the queue contents next elements to pq
*/
public class MergeKLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        for(ListNode list:lists){
            if(list!=null)
                pq.offer(list);
        }


        ListNode head= new ListNode(-1);
        ListNode curr=head;
        while(!pq.isEmpty()){
            ListNode node= pq.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null)
                pq.offer(node.next);
        }

        return head.next;
    }
}

[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],



        [2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211]