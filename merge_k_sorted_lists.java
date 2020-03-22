/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Brute Force
//Stich all the list and then sort it 
//Time: O(NlogN)

//Approach 2:
//Use merge sort to sort two - two lists
//Time: O(NlogK) //confusion about this complexity

//Approach 3
//use Min heap to store k-head nodes of k lists
//Time: O(NLogK) k= elements in heap & N -> largest list 


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length ==0)
            return null;
        
        //Custom comparator
        Comparator<ListNode> nodeComparator = new Comparator<>(){
            
            public int compare(ListNode a, ListNode b)
            {
                return a.val - b.val;
            }
        };
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(nodeComparator);
        
        //put all the head nodes in the minHeap
        for(ListNode node : lists)
        {
            if(node!= null)
                minHeap.add(node);
        }
        
        //create a dummy node
        ListNode temp = new ListNode(0);
        
        //create a cursor pointing to the tail/ current node in the list
        ListNode cursor = temp;
        
        //take out min node from list and attach it to the cursor
        while(!minHeap.isEmpty())
        {
            ListNode minNode = minHeap.poll();
            cursor.next = minNode;
            cursor = minNode;
            if(minNode.next != null)
                minHeap.add(minNode.next);
        }
        
        return temp.next;
    }
}
