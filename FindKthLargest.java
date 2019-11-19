//Time Complexity :O(N*LOG(K)).
//Space Complexity :O(K)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a1, Integer a2){
                if(a1 > a2){return 1;}
                if(a1 == a2){return 0;}
                return -1;
            }
        });
        for(int n: nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}