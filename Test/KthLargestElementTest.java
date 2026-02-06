import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestElementTest {
    public static void main(String[] args) {
        //test the kth largest element in linked list
        KthLargestElement kthLargestElement = new KthLargestElement();
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargestElement.findKthLargestUsingMaxHeap(nums, 4));
        int [] nums2 = new int[]{3,2,1,5,6,4};
        System.out.println(kthLargestElement.findKthLargest(nums2, 2));
    }
}
