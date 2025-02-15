public class Problem1 {
    //t.c -> O(nlogk)
//s.c -> o(k) at most k element will be present in queue
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int n =  nums.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>();//by default is a min heap
            for(int i=0;i<n;i++){//go over each element in list and add it in pq which is min heap so the top most element is min amongst all and if we exceed th size which is k it means we're popping which would be the top element and it means lowest element will pop every time and when we reach till end on the for loop the root would have the k largest element;
                int num = nums[i];
                pq.add(num);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.poll();
        }
    }
}
