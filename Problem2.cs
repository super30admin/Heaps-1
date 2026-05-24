// Time Complexity : O(nlogk) where k is the distinct number of lists and n is the total number of elements
// Space Complexity : O(k) where k is the distinct number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain a min heap where I initially add all the head nodes of the lists given as input. While minHeap is not empty, I dequeue the node from the heap and add it to my resultant list. I check if there
exists a next element for the node dequeued, if so I add it to the min heap. I continue this process till the heap is not empty. At the end I return the resultant list's head.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode MergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode, int> minHeap = new(Comparer<int>.Create((x, y) => x.CompareTo(y)));
        
        foreach(ListNode heads in lists)
        {
            if(heads!=null)
                minHeap.Enqueue(heads,heads.val);
        }

        ListNode temp = new ListNode();
        ListNode head = temp;

        while(minHeap.Count != 0)
        {
            ListNode nextNode = minHeap.Dequeue();
            if(nextNode.next != null)
            {
                minHeap.Enqueue(nextNode.next, nextNode.next.val);
            }
            temp.next = nextNode;
            temp = nextNode;
        }

        return head.next;

    }
}