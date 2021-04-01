//TC: O(nlogk)
//SC: O(nk) for heap. O(logn) for recursion
//Executed on leetcode.
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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new compq());
        
        for(ListNode list:lists)
        {
            if(list!=null)
                minHeap.add(list);
        }
        ListNode dummy = new ListNode(-1);  //Used min heap and to store the given linked lists.
        ListNode curr = dummy;      //Min heap is done based on root node val.
        while(!minHeap.isEmpty())   //After inserting the lists to minheap.
        {                           //Polling the root value on each iteration, so that min value will be polled out every time.
            ListNode ln = minHeap.poll();//Removing the root node inserting the next to heap if it not null.
            
            if(ln.next!=null)       //Traversing till the heap is empty.
                minHeap.add(ln.next);
            while(curr.next!=null)
            {
                curr =curr.next;
                
            } 
            curr.next =new ListNode(ln.val);
            //curr = ln; 
        }
        
        return dummy.next;
    }
    
    class compq implements Comparator<ListNode>
    {
        public int compare(ListNode l1,ListNode l2)
        {
            if(l1.val>l2.val)
                return 1;
            else if(l1.val<l2.val)
                return -1;
            else
                return 0;
        }
    }
}