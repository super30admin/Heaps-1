//using max heap of size N - k
//T.C: O(Nlog(N-K)
//S.C: O(N-K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > (nums.length - k)) {
                result = Math.min(result,pq.poll());
            }
        }
        return result;
    }
}

//using min heap of size k
//T.C: O(NlogK)
//S.C: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}