//Max heap of size n-k
//Time Complexity: n log(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result = Integer.MAX_VALUE;
        for(int num:nums){
            pq.add(num);
            if(pq.size() > nums.length-k){
                result= Math.min(result,pq.poll());
            }
        }
        return result;
    }
}

//Minheap of size k
//Time Complexity: n log k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}