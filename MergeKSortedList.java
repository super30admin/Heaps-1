//Time:O(n*klog(k)) where n = avg length of list, k=number of lists
//Space:O(k)
//Did it run successfully on leetcode: yes
//Did you face any difficulty: no
class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        //creating a min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
        //looping through all the lists
        for(ListNode head: lists){//O(n)
            //if curr list is not null
            if(head !=null){
                //add head of curr list to min heap
                pq.add(head);//nlog(n)
            }
        }
        //dummy node to keep track of our new list
        ListNode dummy = new ListNode(-1);
        //node to keep track of last node of current new list
        ListNode curr = dummy;
        //while min heap has node
        while(!pq.isEmpty()){//n*llog(n)
            //fetch the min node
            ListNode min = pq.poll();
            //if node is not null
            if(min!=null){
                //add it our new list
                curr.next = min;
                //update curr pointer
                curr = curr.next;
                //if next node of min exists
                if(min.next !=null){
                    //add next node to heap
                    pq.add(min.next);
                }
            }
        }
        //return our new list
        return dummy.next;
    }
}