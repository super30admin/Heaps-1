class Solution {
  //TC O(nlogk)  SC O(n)
    class mycomparator implements Comparator<Integer>{
        public int compare(Integer a,Integer b){
            return b-a;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(new mycomparator());
        
        for(int i: nums){
            pq.add(i);
        }
        for(int j=1;j<k;j++)
            pq.poll();
        return pq.peek();
    }
}
