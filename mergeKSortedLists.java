
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class MergeKSortedLists{
    public ListNode mergeKLists(ListNode[] lists){

        //base case
        if(lists == null || list.length == 0){
            return null;
        }

        //min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        //add lists to pq
        for(ListNode list : lists){
            //add each list's head to the pq
            if(list != null){
                pq.add(list);
            }
        }

        //dummy
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        
        //remove elements and append to curr while the heap is not empty
        while(!pq.isEmpty()){
            ListNode popped = pq.poll();
            curr.next = popped;
            if(popped.next != null){
                pq.add(popped.next);
            }
            //move curr
            curr = curr.next;
        }

        return dummy.next;
    }



    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(4));
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1, new ListNode(3));
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{list1, list2, list3};
        
        //Create Object
        MergeKSortedLists m = new MergeKSortedLists();

        ListNode answer = m.mergeKLists(lists);

        ListNode curr = answer;
        while(curr.next != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}