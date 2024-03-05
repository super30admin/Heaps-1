// TC - O(k*N) => N=n*k => 2n+3n+4n......kn => k*k*n => k*N
// SC - O(1)

public class MergeKSortedListsBrute {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length == 0) {
                return null;
            }

            ListNode resultListDummyHead = new ListNode(-1);
            resultListDummyHead.next = lists[0];

            for (int i = 1; i < lists.length; i++) {
                ListNode currList = lists[i];
                resultListDummyHead = mergeTwoLists(resultListDummyHead, currList);
            }

            return resultListDummyHead.next;
        }

        private ListNode mergeTwoLists(ListNode resultListDummyHead, ListNode currList) {
            ListNode currNode = resultListDummyHead;
            ListNode itr1 = resultListDummyHead.next;
            ListNode itr2 = currList;

            while (itr1 != null && itr2 != null) {
                ListNode minNode;
                if (itr1.val <= itr2.val) {
                    minNode = itr1;
                    itr1 = itr1.next;
                } else {
                    minNode = itr2;
                    itr2 = itr2.next;
                }
                currNode.next = minNode;
                currNode = currNode.next;
            }

            if (itr1 != null) {
                currNode.next = itr1;
            }

            if (itr2 != null) {
                currNode.next = itr2;
            }

            return resultListDummyHead;
        }
    }
}
