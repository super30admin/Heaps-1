// T.C- O(Nlogk)
//S.C- O(k)
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q= new PriorityQueue<>();
        
        for(int numbers: nums){
            q.add(numbers);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }
}