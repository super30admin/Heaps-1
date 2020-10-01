/*
 * #23. Merge k Sorted Lists
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

1. k == lists.length
2. 0 <= k <= 10^4
3. 0 <= lists[i].length <= 500
4. -10^4 <= lists[i][j] <= 10^4
5. lists[i] is sorted in ascending order.
6. The sum of lists[i].length won't exceed 10^4.

 */


/*
 * Time Complexity: O (n. log k) -> Heapify everytime just for 3 nodes as min heap will have 3 nodes at a time and we are doing logK(heapify) operation for 'n' elements in k linked lists
 * 									// We are not adding all the nodes to min heap at the sam time, min heap will have juts 3 nodes at any point
 * 
 * Space Complexity: O (K) -> Priority queue will have 3 nodes at same time since we are removing the min then addign the next node of removed node in priority queue
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.heaps1;

import java.util.Comparator;
import java.util.PriorityQueue;


 // Definition for singly-linked list.
class ListNode12 {
	 int val;
	 ListNode12 next;
	 ListNode12() {}
	 ListNode12(int val) { this.val = val; }
	 ListNode12(int val, ListNode12 next) { this.val = val; this.next = next; }
}
 

public class MergeKSortedLists {
	public ListNode12 mergeKLists(ListNode12[] lists) {
        
        // In java, min heap is implemented as a priority queue
        // So, we will create a priority queue which will store reference to List nodes
        // Priority queue will use the comparator while adding nodes to min heap(priority queue)
        PriorityQueue<ListNode12> minHeap = new PriorityQueue<ListNode12>(new pqComparator());
        
        // Add the head(first) node from each list(linked list) in given lists array
        // Input:
        // [1->4->5,
        //  1->3->4,
        //  2->6
        // ]
        for(ListNode12 list : lists){
            if(list != null){
                // Add 1, 1 and 2 in min heap(priority queue)
                minHeap.add(list);
            }
        
        }
        
        // We are creating a dummy node and making it head of a linked list
        // Using dummy node because while adding the removed list nodes from min heap to output one by one we will be changing(assigning) the dummy node as head pointer to newly added node(top) in output
        // By using dummy pointer, we are not changing our head
        // At the end, we need to return merged linked list, 
        // For that, we need reference to head node. we can simply return reference to head as dummyHead.next to return whole merged list
        
        ListNode12 dummyHead = new ListNode12(-1);
        ListNode12 head = dummyHead;
        
        // Repeat until priority queue is empty
        while(!minHeap.isEmpty()){
            
            // Remvove/pop the minimum node from min heap
            ListNode12 top = minHeap.remove();
            
            // Check if the next node of top is not null
            if(top.next != null){
                // If not null, add the next of top to min heap(priority queue)
                // While adding node to min heap, comparator will compare and decide from which LL next node of top 
                // should be added in case when top is same in both LL's
                minHeap.add(top.next);
            }
            
            // Add the removed node to the output
            // Everytime, we add top to output, we make it as head (head = previous top.next)
            // So that we can add next top node in a linked list simply as head.next(previous top.next) = top
            head.next = top;
            head = head.next;
        }
        
        // Finally, return the reference to head pointer -> merged linked list as output
        return dummyHead.next;
        
    }

}


/* 
* Java has an in-built comparator for Integers and int elements
* Here, we have defined our own class ListNode
* Since, we are storing reference to List Nodes in min heap, 
* while adding th List Nodes to min heap from linked lists given,
* If the top(popped) element from min heap is same in 2 given Linked Lists,
* In our case, it is 1 in LL1 and LL2. So, we need to decide from which LL 
* we add the next node to min heap. That's why we have comparator 
* while adding reference of nodes to min heap.
*/

class pqComparator implements Comparator<ListNode12>{
	
    public int compare(ListNode12 s1, ListNode12 s2){
        // If top.next in LL1 > top.next in LL2, return 1
        if(s1.val > s2.val){
            return 1;
        }
        // If top.next in LL1 < top.next in LL2, return -1
        else if(s1.val < s2.val){
            return -1;
        }
        // If top.next in LL1 == top.next in LL2, return 0
        return 0;
        
    }
    
}