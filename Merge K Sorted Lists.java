//  Time Complexity: O(N log k)
//  Space Complexity: O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) ->  l1.val - l2.val);

        ListNode temp = new ListNode(0, null);
        ListNode head = temp;

        for(int i=0; i< lists.length; i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }

        while(pq.size() != 0){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;

            if(curr.next != null)
                pq.add(curr.next);
        }
        temp.next = null;
        return head.next;

    }
}

//  Time Complexity: O(k^2 * n)
//  Space Complexity: O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for(ListNode list: lists){
            result = merge(result, list);
        }
        return result.next;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while(l1 != null && l2!= null){
            if(l1.val < l2.val){
                result.next = l1;
                l1 = l1.next;
            }else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if(l1 != null) result.next = l1;
        else result.next = l2;
        return dummy.next;
    }
}