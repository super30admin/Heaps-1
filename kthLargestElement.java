import java.util.PriorityQueue;

public class kthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,8,9,7,10};
		//int k = 2;
		System.out.println(findKthLargest(nums,2));

	}
	
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
            
        }
        return minHeap.remove();
    }

}
