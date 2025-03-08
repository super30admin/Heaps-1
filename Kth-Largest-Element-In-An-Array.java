## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

//Approach 1:
Using a min heap. In java Min heap is implemented as a Priority Queue. So we will use that. Also, we will not create a Min heap of 
all elements because it will be O(n logn). So we will create it of k size and if the size is greater than k we will poll it.
At the end the top element of the heap will be the Kth largest element. We will return that element.

Time Complexity : O(n log k);
Space Complexity : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int num=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > nums.length-k){
                int number=pq.poll();
                if(num>number){
                    num=number;
                }
            }
        }
        return num;
    }
}

//We can also do it with MAx heap
Time Complexity = O(n log(n-k))
Space Complexity = O(n-k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int num=Integer.MAX_VALUE;
        //Below are the two ways we can define the Max heap in java
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > nums.length-k){
                int number=pq.poll();
                if(num>number){
                    num=number;
                }
            }
        }
        return num;
    }
}