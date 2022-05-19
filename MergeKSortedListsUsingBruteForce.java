/**
 * Time complexity : O(n k^2)
 * Space complexity : O(k)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedListsUsingBruteForce {
    static class ListNodeBF {
        int val;
        ListNodeBF next;
        ListNodeBF() {}
        ListNodeBF(int val) { this.val = val; }
        ListNodeBF(int val, ListNodeBF next) { this.val = val; this.next = next;}
    }

    public static void main(String[] args) {
        ListNodeBF listNode1  = new ListNodeBF(1);
        listNode1.next = new ListNodeBF(4);
        listNode1.next.next = new ListNodeBF(5);

        ListNodeBF listNode2  = new ListNodeBF(1);
        listNode2.next = new ListNodeBF(3);
        listNode2.next.next = new ListNodeBF(4);

        ListNodeBF listNode3  = new ListNodeBF(2);
        listNode3.next = new ListNodeBF(6);

        ListNodeBF[] lists = new ListNodeBF[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;

        ListNodeBF result = mergeKLists(lists);
        System.out.println("Merged list");
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNodeBF mergeKLists(ListNodeBF[] lists) {
        //base condition
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNodeBF merged = null;
        for(ListNodeBF head : lists){
            merged = merge(merged, head);
        }

        return merged;
    }

    private static ListNodeBF merge(ListNodeBF l1, ListNodeBF l2) {
        ListNodeBF dummy = new ListNodeBF(-1);
        ListNodeBF curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }
}
