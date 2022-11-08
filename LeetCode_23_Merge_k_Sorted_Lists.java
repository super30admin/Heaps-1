//approach-2
//k pointers on all the lists, pointing at head. -  and then put all of them to PQ<> at a time 1st element from k lists and then keep extarcting min and adding their next to PQ. 
//
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
        if(lists == null || lists.length ==0) return null;
        
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //add first k nodes to pq
        for(ListNode list : lists)
        {
            if(list != null)
                pq.add(list);
        }

        //process the pq, extract, add , empty it
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
            {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}

//tc - at a time we will just have k elements to process in my Priority Q, but let say avg length of all list is n, then 
//TC -  O(nk log k)
//sc - O(k) - space for the priority Queue. 

//pproach- 1
//take all nodes, store it into array, sort array and then return that. 
//tc - sortingO(X log X) + traversing through list and storing them O(X) ; X = total number of Nodes from k lists. 
//sc - O(X) - array of this size

//approach-2
//k pointers on all the lists, pointing at head. -  and then put all of them to PQ<> at a time 1st element from k lists and then keep extarcting min and adding their next to PQ. 
//
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
        if(lists == null || lists.length ==0) return null;
        
        
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = merged;
        
        //calculate size
        for(ListNode list : lists)
        {
            merged = connect(merged, list);
        }
        
        return dummy.next;
    }
    
    private ListNode connect(ListNode l1, ListNode l2)
    {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode curr = temp;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
       
        return temp.next;
    }
}