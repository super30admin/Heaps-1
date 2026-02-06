import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedListsTest {
    public static ListNode buildList(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return null;
        ListNode head = new ListNode(arr.get(0));
        ListNode curr  = head;
        for (int i = 1; i < arr.size(); i++) {
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }
        return head;
    }
    // List<List<Integer>> -> ListNode[]
    public static ListNode[] buildListsArray(List<List<Integer>> input) {
        if (input == null) return new ListNode[0];

       ListNode[] lists = new ListNode[input.size()];
       for(int i = 0; i < input.size(); i++) {
           lists[i] = buildList(input.get(i));
       }
       return lists;
    }
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int [] arr = new int[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 4, 5));
        list.add(Arrays.asList(1, 3, 4));
        list.add(Arrays.asList(2, 6));
        ListNode[] lists = buildListsArray(list);
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode mergeKLists = sol.mergeKLists(lists);
        printList(mergeKLists);
    }
}
