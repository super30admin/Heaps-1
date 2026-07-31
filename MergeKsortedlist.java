// Time Complexity : O(N log k) where N is the total number of nodes across all lists and k is the number of lists
// Space Complexity : O(N) for storing the merged list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : using dummy node didn't click my mind.

// Your code here along with comments explaining your approach : merge all the nodes from the k sorted lists into a single list, sort that list, and then create a new linked list from the sorted nodes. Finally, return the head of the new linked list.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> temp = new ArrayList<>();
        for(ListNode list : lists){
            ListNode curr = list;
            while(curr != null)
            {
                temp.add(curr);
                curr = curr.next;
            }
        }

        Collections.sort(temp, (a, b) -> {
            return a.val - b.val;
        });

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(ListNode node : temp){
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }
}

