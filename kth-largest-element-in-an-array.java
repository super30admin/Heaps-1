//MinHeap
//TC = O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums, (a,b) -> b - a); //sorting in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){ //n
            pq.add(num); //log(k)
            if(pq.size() > k){
                pq.poll(); //log(k)
            }
        }
        return pq.peek();
    }
}

// //MaxHeap
// //TC = O(nlog(n-k))
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int n = nums.length;
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
//         int result = Integer.MAX_VALUE;
//         for(int num:nums){ //n
//             pq.add(num); //log(k)
//             if(pq.size() > n-k){
//                 result = Math.min(pq.poll(),result);
//             }
//         }
//         return result;
//     }
// }

//Best soltuion is Quick sort solution
//TC = O(n) amortised