class Sample{
    /*********************PROBLEM-1*****************/
    //using max heap
    //TC:0(NlogN)
//SC:0(N)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums==null || nums.length==0){
                return 0;
            }
            PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
            for(int each:nums){
                heap.add(each);
            }
            int i=1;
            while(i<k){
                heap.poll();
                i++;
            }
            return heap.poll();
        }
    }

    //TC:0(Nlog(n-k))
//SC:0(N-k)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums==null || nums.length==0){
                return 0;
            }
            PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
            int min=Integer.MAX_VALUE;
            for(int each:nums){
                heap.add(each);
                if(heap.size()>nums.length-k){
                    min=Math.min(heap.poll(),min);
                }
            }

            return min;
        }
    }

//using min heap
    //TC:0(Nlogk)
//SC:0(N)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums==null || nums.length==0){
                return 0;
            }
            PriorityQueue<Integer> heap=new PriorityQueue<>();
            for(int each:nums){
                heap.add(each);
                if(heap.size()>k){
                    heap.remove();
                }
            }

            return heap.peek();
        }
    }
    /*********************PROBLEM-2*****************/

    //TC:0(NKLogNK)
    //SC:0(N*K)
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }

            ListNode dummy=new ListNode(-1);
            PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->a.val-b.val);
            for(ListNode list:lists){
                if(list!=null){
                    heap.add(list);
                }

            }
            ListNode curr=dummy;
            while(!heap.isEmpty()){
                ListNode min=heap.poll();
                curr.next=min;
                if(min.next!=null){
                    heap.add(min.next);
                }
                curr=curr.next;
            }
            return dummy.next;
        }
    }
}