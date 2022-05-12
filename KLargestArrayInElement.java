//Method 1- Using Min Heap
class Solution {

    //Time Complexity: 0(nlogk) where n is the length of the array and k is the kth element in array to be returned
    //Space Complexity : o(nlogk) where n is the length of the array and k is the kth element in array to be returned
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In short explain your approach

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(); //Creating a priority queue as in java, it acts as min heap by default
        for(int a : nums){  //going over all the elements in the array to form a queue
            p.add(a);   //adding the elements in the queue in order to form a heap
            if(p.size() > k){   //to save on time complexity we are capping our size of queue to the kth element as the logic works perfectly fine when we do so and also helps us on save time
                p.poll();   //popping the min element from queue once we outgrow the kth element or we can also call it capacity of the queue
            }
        }
        return p.peek();    //returning the smallest element in the queue at the end as the root will store the 2nd largest element in the array after traversal
    }
}

//Using Max Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        for(int a : nums){
            p.add(a);
            if(p.size() > nums.length - k){
                result = Math.min(result, p.poll());
            }
        }
        return result;
    }
}