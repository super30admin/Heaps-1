//Time Complexity: O(n*log(k))
//Space Complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>();           //creating a min heap

        for(int i=0; i< nums.length; i++){                      //iterate through nums array

            queue.add(nums[i]);                                 //add element in heap

            if(queue.size() > k){                               //if heap size is greater than k, then remove element from the heap
                queue.remove();
            }



//             if(queue.size() < k){
//                 queue.add(nums[i]);
//             }
//             else{
//                 if(nums[i] > queue.peek()){
//                     queue.poll();
//                     queue.add(nums[i]);
//                 }
//             }
            //System.out.println(queue);

        }
        return queue.poll();                                    //poll the element from queue and return the element
    }
}

public class KthLargestElementInAnArrayLC215 {
}
