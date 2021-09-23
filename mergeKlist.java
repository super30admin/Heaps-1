
//Time complexity : O(N\log N)O(NlogN) 
//Space complexity : O(N)O(N)
class Solution {
    ListNode head;

    public void inserrt(int data)
    {
         ListNode new_node = new ListNode(data);
            if (head == null)
            {
            head = new ListNode(data);
                return;
            }
 
           new_node.next = null;
            ListNode last = head;
            while (last.next != null)
                last = last.next;
            last.next = new_node;
            return;
    }
        
    
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode head1 = null;

        for(int i=0; i<lists.length; i++){
            ListNode head2 = lists[i];
            while(head2 != null){
                arr.add(head2.val);
                head2  = head2.next;
            }
            
        }
        System.out.print(arr);
        Collections.sort(arr);
        System.out.print(arr);

        for(int j=0; j < arr.size(); j++){
               inserrt(arr.get(j));  
        }
        return head;
        
    }
}