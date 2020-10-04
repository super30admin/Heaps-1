class Solution {
     /*Approach 3: Using min heap -- add initial k elems
     * Then, add only those elems greater than the peek
     * If any elem is less than peek, don't add it. Return top of the queue
     * TC - O(KlogK) for addition + O(N-K log K) for processing other K elems ==> O(NlogK)
     * SC - O(K) for priority queue
     */
     public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->{
            return a-b;
        });
        int len = nums.length;
        //add n-k elements to the queue
       for(int i=0; i<k; i++){
           que.add(nums[i]);
       }
        for(int i=k; i<len; i++){
            if(nums[i] > que.peek()){
                que.poll();
                que.add(nums[i]);
            }
        }
        return que.poll();
    }
    
     /*Approach 2: Using max heap -- add initial n-k+1 elems
     * Then, add only those elems less than the peek
     * If any elem is greater than peek, don't add it. Return top of the queue
     * TC - O((N-K)Log(N-K)) for addition + O(K log N-K) for processing other K elems 
     * ==> O(NlogN-K)
     * SC - O(N-K) for priority queue
     */
    public int findKthLargest_MaxHeap_N_KElems(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        int len = nums.length;
        //add n-k elements to the queue
       for(int i=0; i<len-k+1; i++){
           que.add(nums[i]);
       }
        for(int i=len-k+1; i<len; i++){
            if(nums[i] < que.peek()){
                que.poll();
                que.add(nums[i]);
            }
        }
        return que.poll();
    }
        
    /*Approach 1: sort the elements and return the kth largest element
    * TC: O(N logN)
    * SC: O(1)
    */
    public int findKthLargest_Sorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}