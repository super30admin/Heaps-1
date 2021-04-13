// TC - O(Nlogk)
// SC - O(n)

// LC - 23

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
        // Initializing priorityQueue
        PriorityQueue<ListNode> minHeap = new PriorityQueue(new pqComp());
        // Adding all lists to minHeap, heads of all lists are compared and added accordingly
        for(ListNode list : lists){
            if(list != null){
                minHeap.add(list);    
            }
        }
        
		// Create a dummy node -1 and point curr to dummy
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        // Iterate till minHeap is not empty
        while(!minHeap.isEmpty()){
			// Remove an element from minHeap
            ListNode top = minHeap.remove();
            // Add the next node of removed element if not null
            if(top.next != null){
                minHeap.add(top.next);
            }
            // curr.next will be removed element
            curr.next = top;

            curr = top;
            
        }
		// return dummy.next
        return dummy.next;
    }   
    
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

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode l1, ListNode l2) -> l1.val - l2.val);
        
//         for(ListNode list : lists){
//             if(list != null){
//                 minHeap.add(list);    
//             }
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
        
//         while(!minHeap.isEmpty()){
//             ListNode top = minHeap.remove();
            
//             if(top.next != null){
//                 minHeap.add(top.next);
//             }
            
//             curr.next = top;
//             curr = top;
            
//         }
        
//         return dummy.next;
//     }   
// }

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         if(lists.length == 0){
//             return null; 
//         }
        
//         ListNode mainList = lists[0];
        
//         for(int i=1; i<lists.length; i++){
//             mainList = merge(lists[i], mainList);
//         }
//         return mainList;
//     }
    
    
//     private ListNode merge(ListNode l1, ListNode l2){
//         ListNode dummy = new ListNode(-1);
//         ListNode merList = dummy;
//         while(l1 != null && l2 != null){
//             if(l1.val < l2.val){
//                 merList.next = l1;
//                 l1 = l1.next;
//             }else{
//                 merList.next = l2;
//                 l2 = l2.next;
//             }
//             merList = merList.next;
//         }
        
//         if(l1 != null){
//             merList.next = l1;
//         }else if(l2 != null){
//             merList.next = l2;
//         }
//         return dummy.next;
//     }
// }