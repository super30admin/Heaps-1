//binary tree - complete or almost complete binary tree
//min heap - parent < child
//max heap - parent > child
//heap is represented as arrays in memory under the hood
//heap methods- insert()
//inserting an element in heap- insert at last node (last index in array)find parent 
//in array  parent = (i-1)/2, compare new ele with parent swap keep doing it until root in worst case, TC- logn
//peek() - getting index value of first element -O(1)
// remove() - we swape root with last element then remove last element, from array doing so will take O(1), the heapify 
//happens takes O(logn); removing any ele, swap that element with last ele, remove it then do heapify on tree, O(n)- to find 
// the ele + O(logn)
//extractMin()
//by default heaps are min heaps
//to create a heap from ele- O(nlogn)

//brute force- sort it and get the 4rth index- O(nlogn)

//using heap of size k- tc- n(for n ele)(log k (when heapifu happens when insert value) + logk(heapify happen when remove it))
//sc-O(size of heap- k)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();//initializing heap
//         for(int num: nums){
//             pq.add(num);//adding ele to heap. log k
//             if(pq.size()>k){//if ele becomes greater than k remove
//                 pq.poll(); // log k
//             }
//         }
//         return pq.peek();//return top element r min element from 4 largest ele.
   
//     }
// }

//for using max heap we need comparator operator
//by default merger sort it will do

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));// comparator operator to make it to max heap initializing heap
        for(int num: nums){
            pq.add(num);//adding ele to heap. log k
            if(pq.size()>n-k){//if ele becomes greater than k remove
               result = Math.min(result, pq.poll()); // log k
            }
        }
        return result;//return top element r min element from 4 largest ele.
   
    }
}
