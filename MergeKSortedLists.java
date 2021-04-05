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
        PriorityQueue<ListNode> minHeap = new PriorityQueue(new pqComp());
        
        //adding all listnodes to the minHeap
        for(ListNode list : lists){
            if(list != null){
                minHeap.add(list);
            }
        }
        
        //create a dummy node where u can keep track of result list
        //and current node to keep tarck of where you can add the next node
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(!minHeap.isEmpty()){
            //remove top node from minHeap
            ListNode top = minHeap.remove();
            
            //and add the next node of top to the min heap
            if(top.next != null){
                minHeap.add(top.next);
            }
            
            //add the top to the current node and move the current node to the top to add next element
            curr.next = top;
            curr = curr.next; // curr = top;
        }
        //return dummy.next as result list
        return dummy.next;
    }
    
    //custom comparator
    public class pqComp implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2){
            if(l1.val > l2.val){
                return 1;
            }else if(l1.val < l2.val){
                return -1;
            }
            return 0;
        }
    }
}
//time Complexity: O(n) n -> number of nodes
//Space Complexity: O(k) k->total number of lists



// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         //edge case
//         if(lists == null || lists.length == 0){
//             return null;
//         }
        
//         ListNode newHead = lists[0];
        
//         for(int i = 1; i < lists.length; i++){
//             ListNode n1 = newHead;
//             ListNode n2 = (i < lists.length) ? lists[i] : null;
//             ListNode n3 = (i+1 < lists.length) ? lists[i+1] : null;
//             ListNode n4 = (i+2 < lists.length) ? lists[i+2] : null;
//             i = i + 2;
            
//             ListNode newHead1 = mergeLists(n1, n2);
//             ListNode newHead2 = mergeLists(n3, n4);
            
//             newHead = mergeLists(newHead1, newHead2);
//         }
        
//         return newHead;
//     }
    
//     private ListNode mergeLists(ListNode l1, ListNode l2){
        
//         if(l1 == null && l2 == null){
//             return null;
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode temp = dummy;
        
//         while(l1 != null && l2 != null){
//             if(l1.val < l2.val){
//                 temp.next = l1;
//                 l1 = l1.next;
//                 temp = temp.next;
//             }else{
//                 temp.next = l2;
//                 l2 = l2.next;
//                 temp = temp.next;
//             }
//         }
        
//         if(l1 != null){
//             temp.next = l1;
//         }else if(l2 != null){
//             temp.next = l2;
//         }
        
//         return dummy.next;
//     }
// }




/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //edge case
        if(lists == null || lists.length == 0){
            return null;
        }
        
        ListNode newHead = lists[0];
        
        for(int i = 1; i < lists.length; i++){
            newHead = mergeLists(newHead , lists[i]);
        }
        
        return newHead;
    }
    
    private ListNode mergeLists(ListNode l1, ListNode l2){
        
        if(l1 == null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }
}
*/