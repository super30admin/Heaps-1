class FindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {

//*********Solution 1:
//O(nlogn) where n is the number of elements in the array.
//Sort the array and return the n-k indexed element

        /*
        Arrays.sort(nums); // nlogn [1,2,3,4,5] k = 2 --> return 4(index = 3)

        int index = nums.length - k; // length = 5 k = 2 therefore index = length-k

        return nums[index]; // return the element at that index
        */



//********* Solution 2: Min heap *************
//Solution 2: O(nlogk) - min heap O(nlog(n-k)) max heap
//Using Priority queue and min heap if k < length of array or is k is large and almost close to the         length of the array using max heap

       /*
       PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default ascending order

        for(int i : nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        // Iterator iterator = pq.iterator();
        // while(iterator.hasNext()){
        //     System.out.println(iterator.next()+" ");
        // }
        return pq.peek();
        */

//********** Solution 3: Max heap *************

// Time Complexity : O(NLogN-K) iterating through the array and inserting in max heap.
// Space Complexity : O(N-K) in the max heap we are storing n-k elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Three line explanation of solution in plain english: Iterate through all the elements and store n-k elements in max heap, so K elements would be popped out compare the popped out elements to return the Kth largest element

// Your code here along with comments explaining your approach

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));// max heap or max element at head or descending order
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i : nums){ //O(n) Iterating through all the elements and trying to add it to the priority queue
            pq.add(i);
            if(pq.size() > n-k){ // limiting the size of the priorityqueue n-k so just n-k elements are stored
                if(pq.peek() < result){ //max elements would be popped out so just comparing to update the result for kth largest element
                    result = pq.poll();
                }
                else
                    pq.poll();
            }
        }

        // Iterator iterator = pq.iterator();
        // while(iterator.hasNext()){
        //     System.out.println(iterator.next());
        // }

        return result;

    }
}