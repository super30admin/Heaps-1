//Time Complexity=O(nlog(n-k))
//Space Complexity=O(n-k)
public class kthLargestMaxheap {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b-a);
        int n=nums.length;
        int max=Integer.MAX_VALUE;
        for(int num:nums){
            pq.add(num);
            if(pq.size()>n-k){
                int temp=pq.poll();
                max=Math.min(max,temp);
            }
        }
        return max;
    }
}
