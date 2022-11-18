class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> b-a);

        for(int num:nums){
            p.add(num);
        }
        while(k>1){
            p.remove();
            --k;
        }
        return p.remove();
    }
}
//tc=O(n)
//sc=O(n)
