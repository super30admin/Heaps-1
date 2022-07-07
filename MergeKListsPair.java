//Time Complexity=O(NK)
//Space Complexity=O(1)
public class MergeKListsPair {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged=new ListNode(Integer.MIN_VALUE);
        for(ListNode li:lists){
            merged=merge(li,merged);
        }

        return merged.next;

    }
    private ListNode merge(ListNode h1,ListNode h2){
        ListNode result=new ListNode(-1);
        ListNode curr=result;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                curr.next=h1;
                h1=h1.next;
            }else{
                curr.next=h2;
                h2=h2.next;
            }
            curr=curr.next;
        }
        if(h1==null){
            curr.next=h2;
        }
        if(h2==null){
            curr.next=h1;
        }

        return result.next;
    }
}
