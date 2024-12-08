//23. Merge K Sorted Lists - https://leetcode.com/problems/merge-k-sorted-lists/description/
//Time Complexity: O(n*log(k))
//Space Complexity: O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        //MinHeap Comparator for ListNodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if(currMin.next != null){
                pq.add(currMin.next);
            }
        }
        return dummy.next;
    }
}