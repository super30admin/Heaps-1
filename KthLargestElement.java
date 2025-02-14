// create a priority queue
// keep putting elements till size becomes till k
//
// Logic is that if we're going to put all the elements into the Priority queue and start removing elements after size K is reached, then towards the end, we're only left
// with the K largest elements
//
class Solution {
//Time Complexity: O(nlogk)
    //Space Complexity: O(k)
    public int findKthLargest(int[] nums, int k) {

       PriorityQueue<Integer>  pq= new PriorityQueue<>();
       for (int num: nums){
        pq.add(num);
        if (pq.size()> k)
        pq.poll();

       } 
       return pq.poll();
    }
}
