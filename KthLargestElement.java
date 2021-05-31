//Time: O(nlogk) where n=length of input array
//Space: O(k+1)
//Did it run successfully in leetcode: yes
//Did you face any problem: no
class KthLargestElement {
    public int findKthLargest2(int[] nums, int k) {
        //creating a min heap
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //for all elements in input array
        for(int i=0; i<nums.length; i++){
            //add to heap
            q.add(nums[i]);
            //if heap size is more than k
            if(q.size()>k){
                //remove the minimum
                q.poll();
            }
        }
        //return the min element in heap
        return q.peek();
    }
}