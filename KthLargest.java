/*method 1: brute force
        
        where in we sort all elements and give the (n-K)th element as resuslt
        Time complexity: O(nlogn)
        
 method 2: priority queue or min heap add elements one by one in heap. Once the capacity of heap reaches k,
 pop from heap. Internally min-heap maintains the small elements on top. At insertion/heapify is done to maintain    the order. time complexity: O(n log k)

method 3: we can also use max heap.Maintain a pq of size (n-k) and at each poll() record the max element.
          time complexity: O(n log (n-k))
          

method 4: 
Quick Select

time complexity: O(n)
algorothm:
select pivot element. Partion array based on pivot. 
put all element < pivot on it left and elemets > pivot of right. 

check if leftmost < rightmost, if yes stop here

otherwise continue partioning on right
*/
            
class KthLargest {
    
    int []nums;
    public int findKthLargest(int[] nums, int k) {
        
        /*method 2*/
//         PriorityQueue<Integer>pq = new PriorityQueue<>();
        
//         for(int i = 0; i < nums.length;i++){
//             pq.add(nums[i]);
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
        
//         /* method 3: max heap*/
//         PriorityQueue<Integer>pq = new PriorityQueue<>((a,b) -> (b-a));
        
//         int kMax = Integer.MAX_VALUE;
//         for(int i = 0; i < nums.length;i++){
//             pq.add(nums[i]);
//             if(pq.size() > (nums.length-k)){
//                 kMax = Math.min(kMax,pq.poll());
//             }
//         }
      
//        return kMax;
        //return pq.peek();
        
        this.nums = nums;
        if(nums.length == 0)return 0;
        
        return quickSelect(0, nums.length - 1, nums.length - k);
        
        
    }
    
    private int quickSelect(int left, int right, int kIndex){
        //one element
        if(left == right){
            return nums[left];
        }
        
        Random random = new Random();
        
        int pivotIndex = left + random.nextInt(right-left);
        
        pivotIndex = partition(left,right,pivotIndex);
        
        if(pivotIndex == kIndex){
            return nums[kIndex];
        }
        else if(kIndex > pivotIndex){
            //go right
          return  quickSelect(pivotIndex+1, right, kIndex);
        }
            //go left
         return   quickSelect(left, pivotIndex-1, kIndex);
        
    }
    
    private int partition(int left, int right, int pivot){
        
        int currPivotNum = this.nums[pivot];
        
        swap(pivot, right);    
        int currIndex = left;
        for(int i = left;i <= right; i++){
            if(nums[i] < currPivotNum){
                swap(currIndex,i);
                currIndex++;
            }
        }
        //move back pivot element to its actual index
        swap(currIndex, right);
        return currIndex;
    }
    
    private void swap(int i, int j){
        int temp = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = temp;
    }
    
}