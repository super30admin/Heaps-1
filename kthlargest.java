class Solution {
    // TC - O(nlogk)
    // SC - O(k)
    //sorting and taking kth largest element takes o(nlogn), using heaps it can be reduced
    public int findKthLargest(int[] nums, int k) {
        // builds min heap
        // if a number is not in the maximum k elements out of m elements, then it would never be out of n(n>m) elements.Thus, we can peek it out by keeping the size of pq = k and the final top element would be the answer
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
    //     for(int num:nums){
    //         pq.add(num);
    //         if (pq.size()>k){
    //             pq.poll();
    //         }
    //     }
    //     return pq.poll();
    // }
    // n-k smallest elements can be discarded and the minimum of remaining will be the result
    // TC - O(nlog(n-k))
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    int n = nums.length;
    int result = Integer.MAX_VALUE;
    for (int num:nums){
        pq.add(num);
        if (pq.size()>n-k){
            result = Math.min(result, pq.poll());
        }
    }

    return result;
}
}