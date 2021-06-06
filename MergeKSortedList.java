import java.util.*;

public class MergeKSortedList {

    // TC: O(NKLogNK)
    // SC: O(NK)
    // Steps: Iterate all the nodes in the linked list and add it to the list.
    // Covert the list to int array then sort it.
    // Create a new linked list using the int array.
    public ListNode mergeKListsBF(ListNode[] lists) {

        List<ListNode> resultArray = new ArrayList();
        for (int i = 0; i < lists.length; i++) { // O(NK) where N is length of the linked list and K is the lenght of
                                                 // the lists.
            ListNode currentNode = lists[i];
            while (currentNode != null) {
                resultArray.add(currentNode);
                currentNode = currentNode.next;
            }
        }

        int[] resultArray2 = new int[resultArray.size()]; // O(N)
        for (int i = 0; i < resultArray.size(); i++) {
            resultArray2[i] = resultArray.get(i).val;
        }
        Arrays.sort(resultArray2); // O(LogN)
        ListNode currentNode = null;
        ListNode nextNode = null;
        for (int i = resultArray2.length - 1; i >= 0; i--) { // O(N)
            currentNode = new ListNode(resultArray2[i]);
            currentNode.next = nextNode;
            nextNode = currentNode;
        }
        return currentNode;
    }

    // TC: where n is the length of the linkedlist and k is number of list
    // SC: O(NK)
    // Steps: Iterate all the elements in Priority Queue(Max Heap)
    // Iterate the Priority queue and create a new LinkedList
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (b.val - a.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode currentNode = lists[i];
            while (currentNode != null) {
                pq.add(currentNode);
                currentNode = currentNode.next;
            }
        }

        ListNode currentNode = null;
        ListNode nextNode = null;
        int size = pq.size();

        for (int i = size - 1; i >= 0; i--) {
            currentNode = pq.poll();
            currentNode.next = nextNode;
            nextNode = currentNode;
        }

        return currentNode;
    }

    public ListNode mergeKListsOptimizedApproach(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode newNode = pq.poll();
            curr.next = newNode;
            curr = curr.next;
            if (newNode.next != null) {
                pq.add(newNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode[] node = new ListNode().getSameNodeList();
        ListNode reversedList = mergeKSortedList.mergeKListsOptimizedApproach(node);
        System.out.println("The Result" + reversedList);
    }
}
