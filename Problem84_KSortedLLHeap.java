//Time complexity: O(log(n))
//Space complexity: O(k)
//With no Data Structure (No HEAP)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode result = merged;
        //for every list, merge
        for(ListNode list : lists){
            merged = merge(merged, list);
        }
        return result.next;
    }
    
    private ListNode merge (ListNode l1, ListNode l2){
        //declare starting point as dummy
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        //while both the lists are not null
        while(l1 != null && l2 != null){
            //compare the values of the lists
            if(l1.val < l2.val){
                //add the l1 value into the list
                //and increment the pointer l1
                dummy.next = l1;
                l1 = l1.next;
            } else{
                //add the l2 value into the list
                //and increment the pointer l2
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        //copy remainig elements into dummy
        if(l2 != null){
            dummy.next = l2;
        }
        //copy remainig elements into dummy
        if(l1 != null){
            dummy.next = l1;
        }
        return result.next;
    }
    
}

//With HEAPs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        //base case
         if (lists==null || lists.length==0)
             return null;
        //creating dummy and result node
        ListNode dummy = new ListNode(-1);  
        ListNode result = dummy;

        //maintainig a min heap
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);      
        
        //add nodes into the queue till they are null
        for(ListNode head : lists){
            if(head != null){
                queue.add(head);
            }
        }

        //while queue is not empty
        //pop element, compare min and increment the dummy pointer
        while(!queue.isEmpty())  {   
            ListNode min = queue.poll();
            dummy.next = min;
            dummy = dummy.next;
            //add min values in the queue
            if(min.next != null){
                queue.add(min.next);
            }
        }
        
        return result.next;
    }
    
}