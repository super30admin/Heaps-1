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
    public ListNode mergeKLists(ListNode[] lists)
    {
        Queue<ListNode> q = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for (ListNode node:lists)
        {
            if (node!=null)
            {
                ListNode tem = node;

                {
                    while(tem!=null)
                    {
                        q.add(tem);
                        tem = tem.next;
                    }
                }
            }
        }


        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(!q.isEmpty())
        {
            temp.next = q.poll();
            temp = temp.next;
        }

        temp.next = null;

        return ans.next;
    }
}
