// To merge sorted lists, we are using a min-heap to track the smallest elements among the heads of the lists. We add the head of each list to the min heap. 
// Then we repeatedly extract the minimum element from the heap and add it to our merged list. If the extracted element has a next node, we add that next node to the heap.
// Time complexity: O(N log k) - where N is the total number of nodes across all lists and k is the number of lists.
// Space complexity: O(k) - The heap can contain at most k elements at any time, where k is the number of lists.

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>{a, b -> a.`val` - b.`val`}
        for(listNode in lists) {
            if(listNode != null) {
                pq.add(listNode)
            }
        }

        val dummy = ListNode(-1)
        var curr = dummy

        while(pq.isNotEmpty()){
            val min = pq.poll()
            curr.next = min
            curr = curr.next
            if(min.next != null) {
                pq.add(min.next)
            }
        }

        return dummy.next
    }
}